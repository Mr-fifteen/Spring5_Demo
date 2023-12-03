package com.fifteen.spring.aop;/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  22:32
 */

import org.springframework.stereotype.Component;

/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  22:32
 * 将要被增加的基本类
 */
@Component
public class User {
    public void add(){
        System.out.println("User.add...");
    }
}
