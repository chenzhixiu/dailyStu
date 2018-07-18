package com.abead.filter;

import com.abead.util.CookieUtils;
import com.abead.util.JedisUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/27 14:18
 * 也可以实现简单登录功能,这个类个Shiro重合了 要是想测试这个类需要把web.xml Shiro的过滤器注释掉
 */
public class LoginFilter implements Filter {
    private static List<Pattern> urls = new ArrayList<>();
    private static List<Pattern> urls1 = new ArrayList<>();

    static {
        urls.add(Pattern.compile("(.*?)validCode(.*?)"));
        urls1.add(Pattern.compile("(.*?)*.js"));
        urls1.add(Pattern.compile("(.*?)*.css(.*?)"));
        urls.add(Pattern.compile("(.*?)login(.*?)"));
        urls.add(Pattern.compile("(.*?)tomcatStu/"));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();
        if (uri.contains("validCode") || uri.contains("loginServlet")){
            chain.doFilter(req,res);
        }
        Cookie dlbs = CookieUtils.getCookieFromCookies(((HttpServletRequest) req).getCookies(), "DLBS");
        //若果没有登录 或者 登录标识过期 重新登录
        if (dlbs == null || JedisUtil.get(dlbs.getValue()) == null) {
            req.getRequestDispatcher("/index1.jsp").forward(req, res);
        }
    }
}
