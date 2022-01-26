package com.example.jwtprac.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*JwtSecurityConfig클래스는 SecurityConfigurerAdapter를 extends하며 configure메소드를 오버라이드하여 위에서 만든
 JwtFilter를 Security로직에 적용하는 역할을 수행한다*/
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private TokenProvider tokenProvider;

    public JwtSecurityConfig(TokenProvider tokenProvider){
        this.tokenProvider = tokenProvider;
    }
    @Override
    public void configure(HttpSecurity http){
        JwtFilter customerFilter= new JwtFilter(tokenProvider);
        http.addFilterBefore(customerFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
