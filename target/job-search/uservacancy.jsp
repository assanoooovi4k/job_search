<%@ page import="java.util.List" %>
<%@ page import="by.prostrmk.dao.VacancyDao" %>
<%@ page import="by.prostrmk.model.entity.Vacancy" %><%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 14.6.18
  Time: 21.02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User vacancy</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<%
    String username = request.getPathInfo().split("/")[1];
    List<Vacancy> list = (List<Vacancy>) new VacancyDao().getVacanciesByUsername(username);
    for (Vacancy o : list) {
        out.println("<div class='w3-card-4 w3-pale-yellow'" +
                "<header class='w3-container'><h1>" + o.getTitle()+"</h1></header>" +
                "<h6>Username: " + o.getUsername() + "</h6>" +
                "<h4>Salary: " + o.getSalary() + "</h4>" +
                "<p>" + o.getContent() + "</p>" +
                "<footer class='w3-container'><h6>Date: " + o.getDate() + "</p></footer>" +
                "<br><br><br><br><br></div>");
    }
%>

</body>
</html>
