<%--
  Created by IntelliJ IDEA.
  User: chenzhixiu
  Date: 2018/3/28
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="wy" uri="http://template.onjava.com/article/taglib" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%request.setAttribute("aa", "你好1你好2你好3你好4你好5你好6你好7你好8你好9你好0你好1你好2你好3你好4你好5你好6你好7你好8你好9你好0");
    request.setAttribute("ints",new Integer(5));%>
   result:${wy:add(aa,32)}
</body>
</html>
