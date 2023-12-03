package com.fifteen.spring.aop.proxyaop;/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  21:23
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  21:23
 * CGLIB是一个功能强大，高性能的代码生成包。它为没有实现接口的类提供代理，为JDK的动态代理提供了很好的补充。
 * 通常可以使用Java的动态代理创建代理，但当要代理的类没有实现接口或者为了更好的性能，CGLIB 是一个好的选择。
 * CGLIB 的原理
 * CGLIB 原理：动态生成一个要代理类的子类，子类重写要代理的类的所有不是 final 的方法。在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
 * CGLIB 底层：采用ASM字节码生成框架，使用字节码技术生成代理类，比使用 Java 反射效率要高。
 *
 *CGLIB 动态代理步骤：
 *
 * 1、引入 CGLIB 依赖  (cglib-nodep-2.2.jar)
 * 2、定义一个被代理类
 * 3、定义一个拦截器并实现接口 MethodInterceptor
 * 4、代理工厂类
 * 5、通过代理对象调用方法
 *
 *
 */
public class CglibTest {
    public static void main(String[] args) {
        Student cglibProxyStudent = (Student) CglibProxyFactory.creatCglibProxyObj(Student.class);
        cglibProxyStudent.handOut();
    }
}

/**
 * 代理工厂
 */
class CglibProxyFactory {

    public static Object creatCglibProxyObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        // 为加强器指定要代理的业务类（即为下面生成的代理类指定父类）
        enhancer.setSuperclass(clazz);
        // 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法
        enhancer.setCallback(new CglibProxy());
        return enhancer.create();
    }

}



/**
 * 被代理的原始类
 */
class Student{
    public void handOut(){
        System.out.println("学生交作业.");
    }
}


/**
 * 拦截器
 */
class CglibProxy implements MethodInterceptor {

    /**
     * @param o:           代理对象
     * @param method:      被代理方法
     * @param params:      方法入参
     * @param methodProxy: CGLIB方法
     **/
    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        System.out.println("【增强方法】代理对象正在执行的方法：" + method.getName());
        Object result = methodProxy.invokeSuper(o, params);
        return result;
    }

}

