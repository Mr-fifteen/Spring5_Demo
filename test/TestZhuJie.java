/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  22:27
 */

import com.fifteen.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  22:27
 * annotation--注解
 */
public class TestZhuJie {
    @Test
    public void testZj(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        System.out.println(userService.getName());
    }
}
