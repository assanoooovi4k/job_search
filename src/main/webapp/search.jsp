<%@ page import="java.util.List" %>
<%@ page import="by.prostrmk.model.entity.IEntity" %>
<%@ page import="by.prostrmk.dao.VacancyDao" %><%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 17.6.18
  Time: 13.25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
        input[type=text] {
            width: 130px;
            -webkit-transition: width 0.4s ease-in-out;
            transition: width 0.4s ease-in-out;
        }
        input[type=text]:focus {
            width: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<form action="/searchVacancies" method="get">
    <input type="text" name="search" placeholder="Search..">
</form>
<%

    List<IEntity> list = (List<IEntity>)request.getSession().getAttribute("searchList");
    for (IEntity iEntity : list) {
        out.println(iEntity.toJspString());
    }


%>


</body>
</html>
