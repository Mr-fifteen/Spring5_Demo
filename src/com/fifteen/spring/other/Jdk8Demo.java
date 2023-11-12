package com.fifteen.spring.other;/**
 * @Author Mr.fifteen
 * @Date 2023/10/10  23:08
 */

import java.lang.reflect.Proxy;
import java.util.function.Consumer;

/**
 * @Author Mr.fifteen
 * @Date 2023/10/10  23:08
 */
public class Jdk8Demo {

    public static void main(String[] args) {
        test2(msg1->{
            System.out.println(msg1 + "-> 转换为小写：" + msg1.toLowerCase());
        },msg2->{
            System.out.println(msg2 + "-> 转换为大写：" + msg2.toUpperCase());
        });
    }


    public static void test2(Consumer<String> c1, Consumer<String> c2){
        String str = "Hello World";
        //c1.accept(str); // 转小写
        //c2.accept(str); // 转大写
        //c1.andThen(c2).accept(str);
        c2.andThen(c1);

    }
}
