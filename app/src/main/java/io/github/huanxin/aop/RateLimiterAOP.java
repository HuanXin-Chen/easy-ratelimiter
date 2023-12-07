package io.github.huanxin.aop;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @description: 切面实现配置，关注通知方法
 * @author：H_X
 * @date: 2023-12-07
 * @Copyright： 公众号：阿新的杂记
 */

@Slf4j
@Aspect
public class RateLimiterAOP {

    @Pointcut("@annotation(io.github.huanxin.annotation.AccessInterceptor)")
    public void aopPoint() {

    }

    @Before("aopPoint() && @annotation(io.github.huanxin.annotation.AccessInterceptor)")
    public void testAop( ) {
        System.out.println("aop test!");
    }
}
