package com.abead;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/24 18:52
 */
public class SessionSopeTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name =   req.getParameter("name");
      req.getSession().setAttribute("name",name);
      resp.sendRedirect(req.getContextPath()+"/"+"sessionTest.jsp");
    }
}
