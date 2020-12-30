package com.lugew.winsimcloud.ribbon.controller;

import com.lugew.winsimcloud.ribbon.infrasture.feign.oauth2.Oauth2Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夏露桂
 * @date 2020/12/30 15:27
 */
@RestController
@RequestMapping("test")
@RequiredArgsConstructor
@Tag(name = "测试")
public class TestController {
    private final Oauth2Client oauth2Client;

    @PostMapping("test")
    @Operation(description = "test")
    public ResponseEntity<?> test() {
        return oauth2Client.test();
    }
}
