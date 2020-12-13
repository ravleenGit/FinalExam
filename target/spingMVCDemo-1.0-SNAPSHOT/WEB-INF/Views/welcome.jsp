<%--
  Created by IntelliJ IDEA.
  User: Harman.Malhotra
  Date: 12/9/2020
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add an Entry</title>
</head>


<body>
<form action="/login" method="post">
    <h1>Add an Entry</h1>
    Student Number
    <input type="text" name="snumber"> <br>

    Student Name
    <input type="text" name="sname"> <br>

   Student GPA
    <input type="number" name="gpa"> <br>


    <input type="submit">
</form>
</body>
</html>
