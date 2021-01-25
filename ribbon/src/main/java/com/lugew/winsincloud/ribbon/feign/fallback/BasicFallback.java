package com.lugew.winsincloud.ribbon.feign.fallback;

import com.lugew.winsincloud.ribbon.infrasture.feign.oauth2.Oauth2Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author 夏露桂
 * @date 2020/12/30 17:14
 */
@Component
public class BasicFallback implements Oauth2Client {

    @Override
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("error");
    }
}
