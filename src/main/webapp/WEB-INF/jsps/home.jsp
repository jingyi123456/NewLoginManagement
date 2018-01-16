<%@ page import="java.util.List" %>
<%@ page import="com.yunsu.domain.User" %>
    <%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: jingyi
  Date: 2017/9/22
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%! String name = "dds"; %>--%>
    <%--<tr>--%>
        <%--<%--%>
            <%--List<User> list = (List<User>) request.getSession().getAttribute("listA");--%>
            <%--for (User user : list) {--%>
                <%--String name = user.getUname();--%>
                <%--%>--%>
            <%--<td><%=name %></td>--%>
        <%--<%--%>

            <%--}--%>
        <%--%>--%>

    <%--</tr>--%>

    <c:forEach items="${listA}" var="li">
        <tr>
            <td><input id="${li.uname}" type="button" value="${li.uname }"/></td>
            <a href="${pageContext.request.contextPath}/findUser?name=${li.uname}">查询和编辑</a><br/>
        </tr>
    </c:forEach>

    <script type="text/javascript">

    </script>

<%--${user.uname } ||--%>
<%--<fmt:formatDate value="${user.birth }" pattern="yyyy-MM-dd"/>--%>

----------------------------------------------------------------------------
    <form action="/addUser" method="post">
        <input type="submit" value="新建" />
    </form>

</body>
</html>
