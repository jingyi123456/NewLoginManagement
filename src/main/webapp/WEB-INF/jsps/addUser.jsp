<%--
  Created by IntelliJ IDEA.
  User: jingyi
  Date: 2017/9/23
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通讯录管理</title>
</head>
<body>
    <form action="/save" method="post">
        姓名<input type="text" name="uname"/><br/>
        性别<input type="radio" name="sex" value="男" checked/>男
            <input type="radio" name="sex" value="女"/>女<br/>
        生日<input type="text" name="birth" /><br/>
        电话<input type="text" name="telephone"/><br/>
        邮件<input type="text" name="email"/><br/>
        地址<input type="text" name="address"/><br/>
        标签<input type="text" name="remark"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
