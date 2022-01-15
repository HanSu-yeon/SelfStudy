package com.example.jwtprac.config;

import com.example.jwtprac.jwt.JwtAccessDeniedHandler;
import com.example.jwtprac.jwt.JwtAuthenticationEntryPoint;
import com.example.jwtprac.jwt.JwtSecurityConfig;
import com.example.jwtprac.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //이 어노테이션은 메소드 단위로 @PreAuthorize검증 어노테이션을 사용하기 위해 추가한다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    /*TokenProvider, JwtAuthenticationEntryPoint, JwtAccessDeniedHandler를 주입받는 코드를 추가*/
    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**"
                        , "/favicon.ico"
                );
    }
    //필터링
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //Token방식을 사용하므로 csrf설정을 disable한다

                //예외처리를 위해 만들었던 코드를 지정해줌
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                //데이터 확인을 위해 사용하고 있는 h2-console을 위한 설정을 추가해준다
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                //세션을 사용하지 않기 때문에 세션 설정을 STATELESS로 지정해줌
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //아래 지정한 경로의 3가지 API는 Token이 없어도 호출할 수 있도록 허용한다
                .and()
                .authorizeRequests()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/authenticate").permitAll() //로그인을 위한 API
                .antMatchers("/api/signup").permitAll() //회원가입
                .anyRequest().authenticated() //나머지는 로그인해야만 접근 가능

                //JwtFilter를 addFilterBefore메소드로 등록했던 JwtSecurityConfig 클래스도 적용해준다다
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }

}