package com.abead.servlet;

import com.abead.entity.Department;
import com.abead.mapper.DepartmentMapper;
import com.abead.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/28 13:30
 *
 */
public class TestMybatis extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        try {
            DepartmentMapper customerPOJOMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department list =  customerPOJOMapper.selectAvgMax();
            System.out.println();
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.commit();
           if (Optional.ofNullable(sqlSession).isPresent()){
               sqlSession.close();
           }
        }
    }
}
