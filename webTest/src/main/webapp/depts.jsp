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

<h2>Employees in Department</h2>
<table>
	<tr>
	<th><a href="depts?operation=sort&column=ID">ID</a></th>
	<th><a href="depts?operation=sort&column=NAME">Name</a></th>
	<th><a href="depts?operation=sort&column=AGE">Age</a></th>
	<th><a href="depts?operation=sort&column=GENDER">Gender</a></th>
	<th><a href="depts?operation=sort&column=SALARY">Salary</a></th>
	<th><a href="depts?operation=sort&column=EXPERIENCE">Experience</a></th>
	<th><a href="depts?operation=sort&column=LEVEL">Level</a></th>
	
	</tr>
	<c:forEach items="${emps}" var="e">            <%-- second type of writing style , first is below it --%>
		<tr>                                   
			<td><c:out value ="${e.id}"></c:out></td>        <%-- c out is used for writing in a good way . can be used and not --%>
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