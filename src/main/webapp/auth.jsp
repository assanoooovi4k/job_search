<%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 14.6.18
  Time: 13.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>

<form method="post" action="/auth">
    <input type="text"  id="username" name="username" placeholder="username">
    <input type="password" id="password" name="password" placeholder="password">
    <input type="submit" value="submit">
</form>
</body>
</html>
