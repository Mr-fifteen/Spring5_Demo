/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  16:03
 */

import com.fifteen.spring.xml.Book;
import com.fifteen.spring.xml.PBook;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  16:03
 */
public class TestBook {
    @Test
    public void testBook(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book.toString());
    }

    @Test
    public void testPBook(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        PBook book = context.getBean("pBook", PBook.class);
        System.out.println(book.toString());
    }

}
