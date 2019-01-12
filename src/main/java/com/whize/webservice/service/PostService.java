package com.whize.webservice.service;

import com.whize.webservice.domain.posts.PostsRepository;
import com.whize.webservice.web.PostSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
