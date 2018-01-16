<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: jingyi
  Date: 2017/9/25
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/editUser" method="post">
    姓名<input type="text" name="uname" value="${u.uname}" /><br/>

    <c:if test="${u.sex=='男'}">
        性别<input type="radio" name="sex" checked="checked" value="男" />男
        <input type="radio" name="sex" value="女" />女<br/>
    </c:if>

    <c:if test="${u.sex=='女'}">
        性别<input type="radio" name="sex" value="男" />男
        <input type="radio" name="sex" checked="checked" value="女" />女<br/>
    </c:if>

    <%--性别<input type="radio" name="sex" value="男" checked="${u.sex=='男' ? "'checked'":''}"/>男--%>
    <%--<input type="radio" name="sex" value="女" checked="${u.sex=='女' ? "'checked'":''}"/>女<br/>--%>
    <%--生日<fmt:formatDate value="${u.birth}" pattern="yyyy-MM-dd" /><br/>--%>
    生日<input type="text" name="birth" value="<fmt:formatDate value="${u.birth}" pattern="yyyy-MM-dd" />" /><br/>
    电话<input type="text" name="telephone" value="${u.telephone}" /><br/>
    邮件<input type="text" name="email" value="${u.email}" /><br/>
    地址<input type="text" name="address" value="${u.address}" /><br/>
    标签<input type="text" name="remark" value="${u.remark}" /><br/>
    <input type="submit" value="编辑提交"/>
</form>
</body>
</html>
