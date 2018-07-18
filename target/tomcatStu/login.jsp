<%--
  Created by IntelliJ IDEA.
  User: chenzhixiu
  Date: 2018/4/27
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
<html>
<head>
    <title>Please Log in</title>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
</head>
<body>
<h2>Please Log in</h2>

<shiro:guest>
    <p>Here are a few sample accounts to play with in the default text-based Realm (used for this
        demo and test installs only). Do you remember the movie these names came from? ;)</p>


    <style type="text/css">
        table.sample {
            border-width: 1px;
            border-style: outset;
            border-color: blue;
            border-collapse: separate;
            background-color: rgb(255, 255, 240);
        }
        table.sample th {
            border-width: 1px;
            padding: 1px;
            border-style: none;
            border-color: blue;
            background-color: rgb(255, 255, 240);
        }
        table.sample td {
            border-width: 1px;
            padding: 1px;
            border-style: none;
            border-color: blue;
            background-color: rgb(255, 255, 240);
        }
    </style>
</shiro:guest>


   <form name="loginform" action="<%=request.getContextPath()%>/loginServlet" method="post" target="_self">
    <table align="left" border="0" cellspacing="0" cellpadding="3">
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" maxlength="30"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" maxlength="30"></td>
        </tr>
        <tr>
            <td>
                <input type="text" name="code" style="width: 80px;"/><img id="imgObj" alt="验证码" src="<%=request.getContextPath()%>/validCode">
                <a href="#" onclick="changeImg()">换一张</a><br/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="left"><input type="checkbox" name="rememberMe"><font size="2">Remember Me</font></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" name="submit" value="Login"></td>
        </tr>
    </table>
    <div id="showInfo">
          <%
              Object namepass = request.getAttribute("namepass");
              Object code =  request.getAttribute("code");
               if (namepass != null && code != null){
                    %>
                       <p>验证码错误并且用户名或者密码错误</p>
                   <%
               }
               if (namepass != null && code == null){
                   %>
                       <p>用户名或者密码错误</p>
                  <%
               }
                 if (namepass == null && code != null){
                  %>
                       <p>验证错误</p>
                 <%
            }
          %>
    </div>
</form>

</body>
</html>

<script type="text/javascript">
    function changeImg() {
        var imgSrc =$("#imgObj");
        debugger
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
        debugger
    }

    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        if ((url.indexOf("?") >= 0)) {
            url = url + "&timestamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
</script>
