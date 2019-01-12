package com.whize.webservice.service;

import com.whize.webservice.domain.posts.Posts;
import com.whize.webservice.domain.posts.PostsRepository;
import com.whize.webservice.web.PostSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_포스트테이블에_저장된다(){
        //given
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .author("최수인")
                .content("수인이가 본 정후영")
                .title("정후영")
                .build();

        //when
        postService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        Assertions.assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        Assertions.assertThat(posts.getContent()).isEqualTo(dto.getContent());
        Assertions.assertThat(posts.getTitle()).isEqualTo(dto.getTitle());

    }
}
