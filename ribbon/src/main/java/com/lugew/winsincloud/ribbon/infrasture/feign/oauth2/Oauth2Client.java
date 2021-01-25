package com.lugew.winsincloud.ribbon.infrasture.feign.oauth2;

import com.lugew.winsincloud.ribbon.feign.fallback.BasicFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 夏露桂
 * @date 2020/12/30 15:17
 */
@FeignClient(value = "oauth2", fallback = BasicFallback.class)
public interface Oauth2Client {
    @PostMapping("test/hello")
    ResponseEntity<String> test();
}
