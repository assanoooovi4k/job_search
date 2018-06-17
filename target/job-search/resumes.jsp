<%@ page import="java.io.PrintWriter" %>
<%@ page import="by.prostrmk.dao.VacancyDao" %>
<%@ page import="by.prostrmk.model.entity.Vacancy" %>
<%@ page import="java.util.List" %>
<%@ page import="by.prostrmk.model.entity.Resume" %><%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 15.6.18
  Time: 19.34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resumes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
    </style>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<form action="/searchResumes" method="get">
    <input type="text" name="search" placeholder="Search..">
</form>
<%
    List<Resume> list = (List<Resume>) new VacancyDao().getAll("username", Resume.class);
    for (Resume o : list) {
        out.println(o.toJspString());
    }
%>


</body>
</html>
