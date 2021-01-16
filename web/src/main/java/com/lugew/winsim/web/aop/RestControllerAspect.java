package com.lugew.winsim.web.aop;

import com.lugew.winsim.web.response.R;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * RestController 切面
 *
 * @author 夏露桂
 * @since 2021/1/16 16:49
 */
@Aspect
@Component
public class RestControllerAspect {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut() {

    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        result = R.builder()
                .code("hello")
                .data(result)
                .build();
    }
}
