package com.fifteen.spring.service;/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  22:18
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  22:18
 */
@Component(value = "userService")
public class UserService {

    @Value(value = "张三")
    private String name;

    public void add(){
        System.out.println("UserService add ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
