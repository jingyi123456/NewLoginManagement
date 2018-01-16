<%--
  Created by IntelliJ IDEA.
  User: jingyi
  Date: 2017/9/22
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    注册成功<span id="second" style="color: red">3</span>,如果不跳转请<a href="/first">点击这里</a>
    <script type="text/javascript">
        var time = 3;
        var timer;
        timer = setInterval(function(){
            var second = document.getElementById("second");
            if(time > 0){
                time--;
                second.innerHTML = time;
            }else {
                clearInterval(timer);
                location.href="/first";
            }
        },
            1000);
    </script>
</body>
</html>
