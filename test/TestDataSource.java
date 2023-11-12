/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  21:28
 */

import com.fifteen.spring.dao.DruidTest;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  21:28
 */
public class TestDataSource {
    @Test
    public void testDataSourceConn(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        DruidTest druidTest = context.getBean("druidTest", DruidTest.class);
        try {
            druidTest.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void testDataSourceConn2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("database2.xml");
        DruidTest druidTest = context.getBean("druidTest", DruidTest.class);
        try {
            druidTest.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
