<%--
  Created by IntelliJ IDEA.
  User: prostrmk
  Date: 14.6.18
  Time: 14.37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add your vacancy</title>
</head>
<body>

    <form method="post" action="/createVacancy">
        <input name="title" id="title" type="text" placeholder="title" />
        <input name="salary" id="salary" type="text" placeholder="salary" />
        <input name="content" id="content" type="text" placeholder="content of your vacancy" />
        <input type="submit" value="Submit"/>
    </form>

</body>
</html>
