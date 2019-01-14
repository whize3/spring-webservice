package com.whize.webservice.web;

import com.whize.webservice.domain.posts.PostsRepository;
import com.whize.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    // 스프링에서는 Bean주입받는 방식중 @Autowired로 주입하는건 비권장방식이다
    // 권장방식은 생성자 방식이다
    // 따라서 AllArgsConstructor annotation으로 모든 필드를 생성자 생성성
    // lombok 어노테이션을 사용함으로써 의존성 관계가 변경될때마다 생성자 코드를 수정하지 않아도 된다.
   private PostsRepository postsRepository;
   private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostSaveRequestDto dto){
        return postsService.save(dto);
    }
}
