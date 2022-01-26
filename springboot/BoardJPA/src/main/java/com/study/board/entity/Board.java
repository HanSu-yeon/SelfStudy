package com.study.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * Entity클래스는 테이블(Table) 또는 레코드(Record) 역할을 하는 데이터 베이스 그 자체로 생각할 수 있고,
 * 절.대.로 요청(Request)이나 응답(Response)에 사용되어서는 안되기 때문에 반드시 Request,Response클래스를 따로 생성(구분)해 주어야 한다
 * */
@Getter //해당 클래스에 포함된 멤버 변수의 모든 getter메서드를 생성해주는 롬복의 기능
@NoArgsConstructor(access = AccessLevel.PROTECTED) /*해당 클래스의 기본 생성자를 생성해 주는 어노테이션.
												access속성을 이용해 동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어*/
@Entity //해당 클래스가 테이블과 매핑되는 JPA의 엔티티클래스임을 의미
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;
    private int hits;
    private char deleteYn;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;

    @Builder //롬복에서 제공해주는 기능으로, 생성자 대신에 이용하는 패턴
    public Board(String title, String content, String writer, int hits, char deleteYn) {

        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }
}
