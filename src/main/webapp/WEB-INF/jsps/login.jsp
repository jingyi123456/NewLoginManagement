<%--
  Created by IntelliJ IDEA.
  User: jingyi
  Date: 2017/9/22
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
    <form action="/findUserByName" method="post">
        姓名<input type="text" name="uname"/><br/>
        密码<input type="password" name="upassword"/><br/>
        <input type="submit" value="登录"><br/>
    </form>
    <form action="/insertUser" method="post">
        <input type="submit" value="注册">
    </form>
</body>
</html>
