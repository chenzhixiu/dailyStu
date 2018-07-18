package com.abead.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/2 9:47
 */
public class TestFreemaker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Create a data-model */
        Map latest = new HashMap();
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        req.setAttribute("user","Big Joe");
        req.setAttribute("latestProduct",latest);
        req.setAttribute("foo","true");
        req.setAttribute("x",2);
        List<String> person = new ArrayList<String>();
        person.add("123");
        person.add("456");
        person.add("789");
        req.setAttribute("persons",person);
        req.getRequestDispatcher("./index.ftl").forward(req,resp);
    }
}
