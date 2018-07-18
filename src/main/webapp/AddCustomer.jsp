<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>新增客户</title>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>

<body>
<center>
    <h2>新增客户</h2>
    <hr/>
    <form name = "cus">
        客户名称：<input type="text" name="cname"/>
        <br/>
        <a style="float:left">客户性别：</a><select name="csex">
        <option value="0" selected="selected">女</option>
        <option value="1">男</option>
    </select>
        <br/>
        联系方式：<input type="text" name="ctel"/>
        <br/>
        客户住址：<input type="text" name="cadress"/>
        <br/>
        购买产品id：<input type="text" name="cpid"/>
        <br/>
        <input type="button" value="确认" onclick="add()"/>
        <input type="reset" value="重置" />
        <input type="button" value="返回" onclick="back()"/>
    </form>
</center>
</body>
<script type="text/javascript">
    function add(){
        var cname=cus.cname.value;
        var csex=cus.csex.value;
        var ctel=cus.ctel.value;
        var cadress=cus.cadress.value;
        var cpid=cus.cpid.value;
        $(document).ready(function(){
            //设置提交的路径，和参数
            $.post("<%=path%>/AddCustomer",
                {"cname":cname,"csex":csex,"ctel":ctel,"cadress":cadress,"cpid":cpid},
                function(data){//Servlet执行完之后执行方法，data表示的servlet返回数据内容
                    if(data == "true"){
                        alert("客户新增成功");
                        back();
                    }else{
                        alert("客户新增失败，请联系系统管理员");
                    }
                });
        });
    }

    function back(){
        opener.location.reload();
        //window.dialogArguments.query(0);//刷新之前页面
        window.close();//关闭当前页面
    }
</script>
</html>