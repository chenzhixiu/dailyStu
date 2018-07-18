<%--
  Created by IntelliJ IDEA.
  User: chenzhixiu
  Date: 2018/3/24
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p> <%= request.getSession().getAttribute("name")%></p>
</body>
</html>
