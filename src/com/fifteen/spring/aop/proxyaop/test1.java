package com.fifteen.spring.aop.proxyaop;/**
 * @Author Mr.fifteen
 * @Date 2023/11/4  22:03
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author Mr.fifteen
 * @Date 2023/11/4  22:03
 * 通过Proxy实现动态代理练习
 */
public class test1 {
    public static void main(String[] args) {
        //创建接口代理对象类
        Class[] interfaces = {User.class};
        UserImpl user = new UserImpl();
        User newUser = (User) Proxy.newProxyInstance(test1.class.getClassLoader(), interfaces, new UserProxy(user));
        int i = newUser.add(2, 3);
        System.out.println("result:"+i);

        //匿名内部类写法
        User newUser2 = (User) Proxy.newProxyInstance(test1.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("匿名内部类发执行代理:"+method.getName()+",参数:"+Arrays.toString(args));
                Object invoke = method.invoke(user,args);
                System.out.println("匿名内部类发执行代理结束..."+invoke);
                return invoke;
            }
        });
        int i1 = newUser2.add(4, 5);
        System.out.println("result2:"+i1);

    }
}

/**
 * 定义接口
 * 代理对象
 */
interface User{
    /**
     * 增加
     * @param a
     * @param b
     * @return
     */
    public int add(int a,int b);

    /**
     * 更新
     * @param b
     * @return
     */
    public String update(String b);
}

class UserImpl implements User{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String b) {
        return b;
    }
}

/**
 * 创建代理对象代码
 */
class UserProxy implements InvocationHandler{
    //创建的是谁的代理对象,就把谁传进来
    //有参构造
    private Object obj;

    public UserProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑(通知?)
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法执行前
        System.out.println("方法<"+method.getName()+">执行前,传递的参数:"+ Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println("方法执行后..."+obj);
        return res;
    }
}



