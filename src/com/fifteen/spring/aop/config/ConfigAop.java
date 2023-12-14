package com.fifteen.spring.aop.config;/**
 * @Author Mr.fifteen
 * @Date 2023/12/14  22:07
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author Mr.fifteen
 * @Date 2023/12/14  22:07
 * Aop注解配置类
 */
@Configuration
@ComponentScan(basePackages = "com.fifteen.spring.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
