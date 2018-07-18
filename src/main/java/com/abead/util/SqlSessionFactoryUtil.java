package com.abead.util;

import com.abead.entity.Customer;
import com.abead.entity.Demo;
import com.abead.mapper.AutoInsertDemoMapper;
import com.abead.mapper.CustomerPOJOMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/28 13:23
 */
public class SqlSessionFactoryUtil {
    private static final SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory   = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    static class A{
        private String n;
        A(String n){
            this.n = n;
        }
    }
    private static ThreadLocal<A> a  = new ThreadLocal<>();
    public static void testFirstCache(){
       /* SqlSession sqlSession = sqlSessionFactory.openSession();
        AutoInsertDemoMapper aim = sqlSession.getMapper(AutoInsertDemoMapper.class);
        int i = 1;
        List<Demo> list = new ArrayList<>();
        Random random = new Random();
        String[] sexs = new String[]{"male","female"};
        while (i <= 3000000){
            Demo demo = new Demo();
            demo.setId(i);
            demo.setName("egon"+i);
            demo.setGender(sexs[random.nextInt(2)]);
            demo.setEmail("egon"+i+"@oldboy");
            list.add(demo);
              if (list.size() == 1000){
                  aim.autoInsertDemo(list);
                  sqlSession.commit();
                  list = new ArrayList<>();
              }
              i++;
        }*/
        // 获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得dao实体
        CustomerPOJOMapper  userMapper = sqlSession.getMapper(CustomerPOJOMapper .class);
        // 进行两次相同的查询操作
      /*  Customer customer =  userMapper.selectBlog(1);
        customer.setCustomerId("121006006");
        Customer customer2 =  sqlSession.getMapper(CustomerPOJOMapper.class).selectBlog(11);*/
        long a  = userMapper.selectCount();
        Customer customer =  userMapper.selectBlog(1);
        customer.setCustomerId("121006006");
        userMapper.insertCustomer(customer);
        sqlSession.commit();
        System.out.println("\n\n=============================================================");
        // 获得一个新的SqlSession 对象
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        // 进行相同的查询操作
        long b = userMapper.selectCount();
        sqlSession1.commit();
    }
    public static void main(String[] args) {
        testFirstCache();
    }
}
