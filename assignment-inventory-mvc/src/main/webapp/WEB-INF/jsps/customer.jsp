<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  method="POST" action="/customer">
<table>
<tr>
   <td>Id</td>
   <td><input type="text" name="id" value="0"/></td>
</tr>
<tr>
   <td>Name</td>
   <td><input type="text" name="name" value=""/></td>
</tr>
 
 
<tr>
   <td>Age</td>
   <td><input type="number" name="age" value=""/></td>
</tr>
 
 
<tr>
   <td>Address</td>
   <td><input type="text" name="address" value=""/></td>
</tr>
 
 
<tr>
   <td>PermanentAddress</td>
   <td><input type="text" name="permanentAddress" value=""/></td>
</tr>
<tr>
<td colspan="2">
     <input name="action" value="Submit" type="submit"/>
   
     </td>
  </tr>
 
</table>
 
 
</form>
 
 
<table>
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>Address</th>
<th>PerAddress</th>
<th>CustomerStatus</th>
 
 
<c:forEach items="${cvo}" var="c">
<tr>
   <td><c:out value="${c.cid}"></c:out></td>
   <td>${c.customerName}</td>
    <td>${c.customerAge}</td>
     <td>${c.customerAddress}</td>
      <td>${c.customerPerAddress}</td>
     <td>${c.customerStatus}</td>
      
</tr>
 
</c:forEach>
 
</table>
 
 
 
</body>
</html>