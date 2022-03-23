package com.example.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//Entity 클래스에서는 절대 setter 메서드를 만들지 않음
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙을 나타냄. GenerationType.IDENTITY-->auto_increment
    private Long id;

    @Column(length=500, nullable =false)
    private String title;

    @Column(columnDefinition="TEXT" , nullable=false)
    private String content;

    private String author;

    @Builder //빌더 패턴을 사용하면 필드에 채워지는 값을 명확하게 인지할 수 있다
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
