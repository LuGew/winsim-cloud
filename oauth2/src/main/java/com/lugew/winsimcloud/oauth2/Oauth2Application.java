package com.lugew.winsimcloud.oauth2;

import com.lugew.winsimcloud.web.configuration.EnableStandardResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableStandardResponse
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}
