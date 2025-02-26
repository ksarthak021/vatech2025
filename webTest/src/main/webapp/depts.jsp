<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 Counters = ${counters}
 Current Dept = ${current}
 <h2>Department Details</h2>
 
<form action="depts" method="post">
<table>
	<tr>
		<td>Id</td>
		<td>${dept.id}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${dept.name}</td>
	</tr>
	<tr>
		<td>Location</td>
		<td>${dept.location}</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type = "submit" name = "operation" value = "First"/>
			<input type = "submit" name = "operation" value = "Previous"/>
			<input type = "submit" name = "operation" value = "Next"/>
			<input type = "submit" name = "operation" value = "Last"/>
		</td>
		
	</tr>
</table>
</form>
<hr></hr>

<hr>
<h2>Employees in ${dept.name} Department</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Salary</th>
        <th>Experience</th>
        <th>Level</th>
    </tr>
    <c:forEach items="${employees}" var="e">
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

<hr></hr>

</body>
</html>