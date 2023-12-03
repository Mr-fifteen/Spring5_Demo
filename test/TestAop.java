/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  22:48
 */

import com.fifteen.spring.aop.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Mr.fifteen
 * @Date 2023/12/3  22:48
 */
public class TestAop {
    @Test
    public void testBook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
