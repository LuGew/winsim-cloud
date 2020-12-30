package com.lugew.winsimcloud.oauth2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夏露桂
 * @date 2020/12/30 15:22
 */
@RestController
@RequestMapping("test")
public class TestController {
    @PostMapping("hello")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello world");
    }
}
