<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department & Employee Details</title>
</head>
<body>

<h2>Department Details</h2>
<c:if test="${empty dept}">
    <p style="color: red;"></p>
</c:if>
<table border="1">
    <tr><td>Department ID</td><td>${dept.id}</td></tr>
    <tr><td>Name</td><td>${dept.name}</td></tr>
    <tr><td>Location</td><td>${dept.location}</td></tr>
</table>

<hr>


<form action="depts" method="post">
    <input type="submit" name="operation" value="First"/>
     <input type="submit" name="operation" value="Next"/>
    <input type="submit" name="operation" value="Previous"/>
    <input type="submit" name="operation" value="Last"/>
</form>

<hr>

<h2>Employee Details</h2>
<c:if test="${empty employees}">
    <p style="color: red;"> No Employees Found in This Department!</p>
</c:if>
<table border="1">
    <tr>
        <th>Employee ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Salary</th>
        <th>Experience</th>
        <th>Level</th>
    </tr>
    <c:forEach var="e" items="${employees}">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.age}</td>
            <td>${e.gender}</td>
            <td>${e.salary}</td>
            <td>${e.experience}</td>
            <td>${e.level}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
