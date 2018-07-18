<%--
  Created by IntelliJ IDEA.
  User: chenzhixiu
  Date: 2018/6/7
  Time: 13:50
  To change this template use File | Settings | File Templates. //没有完成
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" charset="UTF-8" src="./js/jquery-1.8.3.js"/>
    <script type="text/javascript">
        function testcrossdomain() {
            $.ajax({
                url:"",
                type:get,
                dataType:text,
                success:function (data) {

                }
            })
        }
    </script>
</head>
<body>
      <button id="button" onclick="testcrossdomain()" value="testcrossdomain"></button>
</body>
</html>
