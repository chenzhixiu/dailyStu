package com.abead.servlet;

import com.abead.entity.Customer;
import com.abead.proxy.CustomerDAOFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/3/26 10:05
 */
public class FindCustomerById extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cID = request.getParameter("cid");
        Customer pojo = CustomerDAOFactory.getDAOInstance().findById(cID);
        request.setAttribute("pojo", pojo);
        request.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
    }
}
