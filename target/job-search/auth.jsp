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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        .center{
            margin: auto;
            width: 50%;
            padding: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<%--<form class="w3-container">--%>

    <%--<input class="w3-input" type="text">--%>
    <%--<label>First Name</label>--%>

    <%--<input class="w3-input" type="text">--%>
    <%--<label>Last Name</label>--%>

<%--</form>--%>
<form method="post" class="w3-container w3-card-4 center" style="margin-top: 10%" action="/auth">
    <h2>Please auth in our system</h2>
    <input class="w3-input" type="text" id="username" name="username" placeholder="username">
    <input class="w3-input" type="password" id="password" name="password" placeholder="password">
    <input class="w3-input" type="submit" value="submit">
</form>
</body>
</html>
