package com.study.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;

//MyBatis의 Mapper == JPA의 Repository //board테이블의 CRUD쿼리를 자동으로 생성해주는 레파지토리 인터페이스
//엔티티 클래서와 레파지토리 인터페이스는 꼭 같은 패키지에 위치해야 함
//JpaRepository<엔티티의 타입클래스, p.k값의 type>
public interface BoardRepository extends JpaRepository<Board, Long> {

}
