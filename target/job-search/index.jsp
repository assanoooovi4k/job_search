<%@ page import="by.prostrmk.dao.VacancyDao" %>
<%@ page import="by.prostrmk.model.entity.Vacancy" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.prostrmk.model.util.MailUtil" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
    </style>

</head>
<body class="w3-light-grey">
<jsp:include page="navbar.jsp"/>

<div class="w3-content">
    <%
        try {
            new MailUtil("assanoooovi4ksite@gmail.com","Twixpool1999").send("Hello","Hello!", "brinkpool@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
//
//        VacancyDao vacancyDao = new VacancyDao();
//        List<Vacancy> vacancyList = vacancyDao.getAll("id", Vacancy.class);
//
//        for (Vacancy o : vacancyList) {
//            out.println(o.toJspString());
//        }

    %>

</div>

</body>
</html>