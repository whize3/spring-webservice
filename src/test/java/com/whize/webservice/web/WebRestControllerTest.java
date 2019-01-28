package com.whize.webservice.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void Profile확인(){
        //when
        String profile = this.restTemplate.getForObject("/profile",String.class);

        //then
        Assertions.assertThat(profile).contains("local");

    }
}
