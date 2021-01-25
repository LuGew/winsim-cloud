package com.lugew.winsincloud.oauth2.controller;

import com.lugew.winsincloud.oauth2.entity.User;
import com.lugew.winsincloud.oauth2.service.UserService;
import com.lugew.winsin.core.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夏露桂
 * @date 2020/12/31 17:39
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BasicController<User, UserService, Long> {
    @PostMapping("/userNotFound")
    public void userNotFound() {
        throwException(Error.USER_NOT_FOUND.getCode());
    }

    @PostMapping("/internalServerError")
    public void internalServerError() {
        throwException(Error.INTERNAL_SERVER_ERROR.getCode());
    }
}
