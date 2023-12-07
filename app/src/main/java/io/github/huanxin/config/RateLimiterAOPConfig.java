package io.github.huanxin.config;

import io.github.huanxin.aop.RateLimiterAOP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author：H_X
 * @date: 2023-12-07
 * @Copyright： 公众号：阿新的杂记
 */
@Slf4j
@Configuration
public class RateLimiterAOPConfig {
    @Bean
    public RateLimiterAOP rateLimiterAOP() {
        return new RateLimiterAOP();
    }
}
