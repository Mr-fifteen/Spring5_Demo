package com.fifteen.spring.dao;/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  21:20
 */


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author Mr.fifteen
 * @Date 2023/10/29  21:20
 */
public class DruidTest {

    private DataSource dataSource;

    public void getConnection() throws SQLException {

        DataSource ds = dataSource;
        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
