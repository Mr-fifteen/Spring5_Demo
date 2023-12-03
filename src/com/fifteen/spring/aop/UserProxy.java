package com.fifteen.spring.aop;/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  22:34
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  22:34
 * 增强类
 *
 * 切入点表达式
 * （1）切入点表达式作用：知道对哪个类里面的哪个方法进行增强
 * （2）语法结构： execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]) )
 * 举例 1：对 com.atguigu.dao.BookDao 类里面的 add 进行增强
 * execution(* com.atguigu.dao.BookDao.add(..))
 * 举例 2：对 com.atguigu.dao.BookDao 类里面的所有的方法进行增强
 * execution(* com.atguigu.dao.BookDao.* (..))
 * 举例 3：对 com.atguigu.dao 包里面所有类，类里面所有方法进行增强
 * execution(* com.atguigu.dao.*.* (..))
 *
 */
@Component
@Aspect  //生成代理对象
public class UserProxy {
    /**
     * 前置通知
     */
    @Before(value = "execution(* com.fifteen.spring.aop.User.add(..))")
    public void before(){
        System.out.println("User.before...");
    }

    //后置通知（返回通知）
    @AfterReturning(value = "execution(* com.fifteen.spring.aop.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning.........");
    }
    //最终通知
    @After(value = "execution(* com.fifteen.spring.aop.User.add(..))")
    public void after() {
        System.out.println("after.........");
    }
    //异常通知
    @AfterThrowing(value = "execution(*  com.fifteen.spring.aop.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }
    //环绕通知
    @Around(value = "execution(* com.fifteen.spring.aop.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws
            Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
    }

}
