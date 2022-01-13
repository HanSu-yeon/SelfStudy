package com.study.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.board.entity.Board;
import com.study.board.entity.BoardRepository;

@SpringBootTest //테스팅하겠다
	public class BoardTest {
	@Autowired
	BoardRepository boardRepository;//스프링 컨테이너에 등록된 BoardRepository객체(Bean)을 주입받는다
	
	@Test
	void save() {
		//1.게시글 파라미터 생성
		Board params = Board.builder() //params는 Builder패턴을 통해 생성된 객체
				.title("1번 게시글 제목")
				.content("1번 게시글 내용")
				.writer("한수")
				.hits(0)
				.deleteYn('N')
				.build();
		//2.게시글 저장
		boardRepository.save(params);
		//3.1번 게시글 정보 조회
		Board entity =boardRepository.findById((long)1).get();
		assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriter()).isEqualTo("한수");
	}
		@Test
		void findAll() {
			
			//1.전체 게시글 수 조회
			long boardsCount = boardRepository.count();
		
			//2.전체 게시글 리스트 조회
			List<Board> boards = boardRepository.findAll();
		}
		
		@Test
		void delete() {
			
			//1.게시글 조회
			Board entity = boardRepository.findById((long)1).get();

			//2.게시글 삭제
			boardRepository.delete(entity);
	}
}
