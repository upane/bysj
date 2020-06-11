package com.pan.main;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainApplicationTests {

    @Test
    void contextLoads() {
        String salt="1";
        Long sa=2L;
        Md5Hash md5 = new Md5Hash("123456",String.valueOf(sa));
        //eeafb716f93fa090d7716749a6eefa72
        //9a440f1f071dad3043b6c8ba93bb761c
        System.out.println(md5);

    }

}
