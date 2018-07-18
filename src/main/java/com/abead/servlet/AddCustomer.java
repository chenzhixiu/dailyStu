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
 * @Date 创建时间 : 2018/3/26 10:01
 */
public class AddCustomer extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cname = request.getParameter("cname");
        int csex = Integer.parseInt(request.getParameter("csex"));
        String ctel = request.getParameter("ctel");
        String cadress = request.getParameter("cadress");
        String cpid =request.getParameter("cpid");
        Customer pojo = new Customer(cname,csex,ctel,cadress,cpid);
        System.out.println("输出数据："+pojo.toString());
        boolean flag= CustomerDAOFactory.getDAOInstance().doIns(pojo);
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append(flag);
        out.print(sb.toString());
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
