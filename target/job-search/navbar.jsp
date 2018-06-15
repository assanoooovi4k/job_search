<%@ page import="by.prostrmk.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 14.6.18
  Time: 19.53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<% User user = session.getAttribute("user") == null? new User("anon") : (User)session.getAttribute("user");%>
<div class="w3-bar w3-white w3-large">
    <a href="/" class="w3-bar-item w3-button w3-red w3-mobile"><i class="fa fa-bed w3-margin-right"></i>Jobs for you</a>
    <a href="/resumes" class="w3-bar-item w3-button w3-mobile">Find a worker</a>
    <a href="/vacancies" class="w3-bar-item w3-button w3-mobile">Find a job</a>
    <a href="/me" class="w3-bar-item w3-button w3-right w3-light-grey w3-mobile">Your room</a>
</div>
</body>
</html>
