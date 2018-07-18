package com.abead.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 9:52
 */
public class JDBCHelper {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/onjava?serverTimezone=CTT";
    public static final String DBNAME = "root";
    public static final String PASSWORD = "root";
    public static Connection getConn() throws Exception{
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, DBNAME, PASSWORD);
        return conn;
    }
}
