/**
 * @Author Mr.fifteen
 * @Date 2023/9/17  22:22
 */

import com.fifteen.spring.xml.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Mr.fifteen
 * @Date 2023/9/17  22:22
 */


public class TestUser {

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();

        //底层原理 实现
        try {
            User user2= getUser();
            user2.add();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过反射方式获取对象
     * @return
     */
    public static User getUser() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String xmlBeanClassValue = "com.fifteen.spring.xml.User";
        Class<?> aClass = Class.forName(xmlBeanClassValue);
        return (User) aClass.newInstance();

    }











}
