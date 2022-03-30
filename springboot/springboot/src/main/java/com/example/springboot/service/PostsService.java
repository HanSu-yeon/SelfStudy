package com.example.springboot.service;


import com.example.springboot.domain.posts.Posts;
import com.example.springboot.domain.posts.PostsRepository;
import com.example.springboot.web.dto.PostsListResponseDto;
import com.example.springboot.web.dto.PostsResponseDto;
import com.example.springboot.web.dto.PostsSaveRequestDto;
import com.example.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        //repository의 save()메소드의 매개변수로는 Entity형태만을 받을 수 있다-->DTO클래스에서 entity로 변형하는 메소드 호출해서 넘김
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 업습니다.id= " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다 id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        //postsRepository 결과로 넘어온 Posts의 stream을 map을 통해 PostsListResponseDto로 변환 -> List로 반환하는 메서드
        // .map(PostsListResponseDto::new) --> .map(posts ->new PostsListResponseDto(posts))
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);


    }
}