<%@page isELIgnored="false"%>
<%@ page language="java" import="java.util.*,com.abead.entity.Customer" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    Customer pojo = (Customer)request.getAttribute("pojo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>更新客户</title>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>

<body>

<center>
    <h2>更新客户</h2>
    <hr/>
    <form name = "cus">
        <input type="hidden" name="cid" value = "<%=pojo.getCustomerId()%>"/>
        <br/>
        客户名称：<input type="text" name="cname" value = "${pojo.customerName}"/>
        <br/>
        客户密码：<input type="text" name="cpassword" value = "${pojo.password}"/>
        <br/>
        客户性别：<input type="text" name="csex" value = "${pojo.customerSex}"/>
        <br/>
        联系方式：<input type="text" name="ctel" value = "${pojo.customerTel}"/>
        <br/>
        客户住址：<input type="text" name="cadress" value = "${pojo.customerAdress}"/>
        <br/>
        购买产品id：<input type="text" name="cpid" value = "${pojo.customerProId}"/>
        <br/>
        客户状态：<input type="text" name="isDelete" value = "${pojo.isDelete}"/>
        <br/>
        客户标识：<input type="text" name="roleMark" value = "${pojo.roleMark}"/>
        <br/>
        <input type="button" value="确认" onclick="upd()"/>
        <input type="button" value="返回" onclick="back()"/>
    </form>
</center>
</body>
<script type="text/javascript">
    function upd(){
        var cid=cus.cid.value;
        var cname=cus.cname.value;
        var cpassword=cus.cpassword.value;
        var csex=cus.csex.value;
        var ctel=cus.ctel.value;
        var cadress=cus.cadress.value;
        var cpid=cus.cpid.value;
        var isDelete=cus.isDelete.value;
        var roleMark=cus.roleMark.value;
        $(document).ready(function(){
            //设置提交的路径，和参数
            $.post("<%=path%>/CustomerUpd",
                {"cid":cid,"cname":cname,"cpassword":cpassword,"csex":csex,"ctel":ctel,"cadress":cadress,"cpid":cpid,"isDelete":isDelete,"roleMark":roleMark},
                function(data){//Servlet执行完之后执行方法，data表示的servlet返回数据内容
                    if(data == "true"){
                        alert("客户修改成功");
                        back();
                    }else{
                        alert("客户修改失败，请联系系统管理员");
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