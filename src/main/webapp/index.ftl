<html>
<head>
    <title>Welcome!</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>

    <h1>Welcome ${user}!</h1>
    <p>Our latest product:
    <a href="${latestProduct.url}">${latestProduct.name}</a>!

    <#if x < 5>
        Pythons are cheaper than elephants today.
    <#else>
        Pythons are not cheaper than elephants today.
    </#if>

    <table border=1>
    <#list persons as person>
    <tr><td>${person}<td>Euros
    </#list>
    </table>

    <#if foo??><h1> foo : ${foo}!</h1></#if><br/>
    <form action="testMybatis" method="post">

        <input name="id" type="text" value="121006037">
        <input value="submit" type="submit">
    </form><br>
</body>
</html>