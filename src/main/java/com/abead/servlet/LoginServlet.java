package com.abead.servlet;

import com.abead.util.JedisUtil;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/26 14:34
 */
public class LoginServlet extends HttpServlet{
    private static final transient Logger log = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       // ThreadContext.unbindSubject();//解除线程上下文绑定
        HttpSession sessionId = req.getSession();
        String usernmae = (String)req.getParameter("username");
        String password = (String)req.getParameter("password");
        String rememberMe = (String)req.getParameter("rememberMe");
        String code = (String)req.getParameter("code");
        String codeReal = JedisUtil.get(sessionId.getId());
        if (codeReal.equalsIgnoreCase(code) && StringUtils.isNotBlank(usernmae)){
             //登录
           Subject  currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                UsernamePasswordToken token = new UsernamePasswordToken(usernmae, password);
                if ("on".equals(rememberMe)){
                    token.setRememberMe(true);
                }
                try {
                    currentUser.login(token);
                    //设置登录成功的标识
                    String hash = Hashing.hmacMd5("123".getBytes()).hashString(usernmae,Charset.forName("UTf-8")).toString();
                    JedisUtil.setEx(hash,usernmae,20);
                    Cookie cookie = new Cookie("DLBS",hash);
                    resp.addCookie(cookie);
                    resp.sendRedirect("./home.jsp");
                } catch (UnknownAccountException uae) {
                    log.info("There is no user with username of " + token.getPrincipal());
                    req.setAttribute("namepass","用户名或者密码错误");
                    dealError(code,codeReal,req,resp);
                } catch (IncorrectCredentialsException ice) {
                    log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                    req.setAttribute("namepass","用户名或者密码错误");
                    dealError(code,codeReal,req,resp);
                } catch (LockedAccountException lae) {
                    log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                            "Please contact your administrator to unlock it.");
                    req.setAttribute("lock","账户已锁定");
                    dealError(code,codeReal,req,resp);
                }
                catch (AuthenticationException ae) {

                }
            }
            //记录设置登录日志
            //--TODO
        }else {
            dealError(code,codeReal,req,resp);
        }
    }

    public void dealError(String code,String codeReal,HttpServletRequest req,HttpServletResponse resp){
        if (!codeReal.equals(code)){
            req.setAttribute("code","验证码错误");
        }
        try {
            req.getRequestDispatcher("./login.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
