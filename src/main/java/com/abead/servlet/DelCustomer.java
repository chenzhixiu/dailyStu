package com.abead.servlet;

import com.abead.proxy.CustomerDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 10:04
 */
public class DelCustomer extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String customerId = request.getParameter("customerId");
        boolean flag = CustomerDAOFactory.getDAOInstance().doDel(customerId);
        System.out.println(flag);
        out.print(flag);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
