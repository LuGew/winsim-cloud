package com.lugew.winsimcloud.oauth2.controller;

import com.lugew.winsim.web.AbstractController;
import com.lugew.winsimcloud.oauth2.entity.Test;
import com.lugew.winsimcloud.oauth2.service.TestService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "测试")
public class TestController extends AbstractController<Test, TestService, Long> {
    @PostMapping("hello")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello world");
    }
}
