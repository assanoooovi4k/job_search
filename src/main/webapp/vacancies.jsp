<%@ page import="java.util.List" %>
<%@ page import="by.prostrmk.dao.VacancyDao" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="by.prostrmk.model.entity.Vacancy" %><%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 14.6.18
  Time: 13.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancies</title>
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
<div class="w3-card-4">

    <form action="/searchVacancies" method="get">
        <input type="text" name="search" placeholder="Search..">
    </form>
    <%
        List<Vacancy> list = (List<Vacancy>) new VacancyDao().getAllVacancies();
        PrintWriter writer = response.getWriter();
        for (Vacancy o : list) {
            out.println("<div class='w3-card-4 w3-pale-yellow'" +
                    "<header class='w3-container'><h1>" + o.getTitle()+"</h1></header>" +
                    "<h6>Username: " + o.getUsername() + "</h6>" +
                    "<h4>Salary: " + o.getSalary() + "</h4>" +
                    "<p>" + o.getContent() + "</p>" +
                    "<h6>Date: " + o.getDate() + "</p>" +
                    "<br><br><br><br><br></div>");
        }
    %>

</div>



</body>
</html>
