package com.lugew.winsimcloud.oauth2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author 夏露桂
 * @date 2020/12/31 17:39
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(principal.toString());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        return principal;
    }
}
