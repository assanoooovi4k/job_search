<%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 14.6.18
  Time: 22.21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create your resume</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<form method="post" action="/createResume">
    <input name="title" id="title" type="text" placeholder="Title" />
    <input name="university" id="university" type="text" placeholder="Your university" />
    <input name="content" id="content" type="text" placeholder="Tell us about you" />
    <input type="submit" value="Submit"/>
</form>


</body>
</html>
