package com.abead.servlet;

import com.abead.entity.Customer;
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
 * @Date 创建时间 : 2018/3/26 10:03
 */
public class CustomerUpd extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String customerId = request.getParameter("cid");
        String customerName = request.getParameter("cname");
        String password = request.getParameter("cpassword");
        int customerSex = Integer.parseInt(request.getParameter("csex"));
        String customerTel = request.getParameter("ctel");
        String customerAdress = request.getParameter("cadress");
        String customerProId = request.getParameter("cpid");
        int isDelete=Integer.parseInt(request.getParameter("isDelete"));
        int roleMark=Integer.parseInt(request.getParameter("roleMark"));
        Customer pojo = new Customer(customerId, customerName,password,customerSex,customerTel,customerAdress,customerProId, isDelete, roleMark);
        System.out.println("输出数据："+pojo.toString());
        boolean flag = CustomerDAOFactory.getDAOInstance().doUpd(pojo);
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append(flag);
        out.print(sb.toString());
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
