package com.lugew.winsincloud.oauth2;

import com.lugew.winsin.mybatis.configuration.EnableMyBatisPlusPaging;
import com.lugew.winsin.web.configuration.EnableStandardResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableStandardResponse
@EnableMyBatisPlusPaging
@MapperScan("com.lugew.winsimcloud.oauth2.repository")
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}
