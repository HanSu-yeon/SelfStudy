package com.example.springboot.service;


import com.example.springboot.domain.posts.PostsRepository;
import com.example.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        //repository의 save()메소드의 매개변수로는 Entity형태만을 받을 수 있다-->DTO클래스에서 entity로 변형하는 메소드 호출해서 넘김
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
