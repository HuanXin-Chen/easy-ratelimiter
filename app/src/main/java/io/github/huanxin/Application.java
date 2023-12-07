package io.github.huanxin;

import io.github.huanxin.annotation.AccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author：H_X
 * @date: 2023-12-07
 * @Copyright： 公众号：阿新的杂记
 */
@Slf4j
@SpringBootApplication
@RestController
@Configurable
@RequestMapping("/api/ratelimiter/")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    
    @AccessInterceptor(key = "fingerprint", fallbackMethod = "loginErr", permitsPerSecond = 1.0d, blacklistCount = 10)
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(String fingerprint,String uId,String token) {
        log.info("模拟登录 fingerprint:{}", fingerprint);
        return "模拟登录:登录成功 " + uId;
    }

    public String loginErr(String fingerprint,String uId,String token) {
        return "频次限制:请勿恶意访问 " + uId;
    }
}
