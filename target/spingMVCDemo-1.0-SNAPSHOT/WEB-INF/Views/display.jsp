<%--
  Created by IntelliJ IDEA.
  User: Harman.Malhotra
  Date: 12/9/2020
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>

Result is : <%= request.getAttribute("loggedInUser") %>
<br>
Name : ${loggedInUser.firstName} ${loggedInUser.lastName}

</body>
</html>
