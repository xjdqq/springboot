<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/25 0025
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/login.html">
    <input type="text" id="name" name="name">
    <input type="password" id="password" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
