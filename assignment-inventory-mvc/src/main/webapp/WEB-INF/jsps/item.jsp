<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  method="POST" action="/item">
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
   <td>Description</td>
   <td><input type="text" name="description" value=""/></td>
</tr>
 
 
<tr>
   <td>Quantity</td>
   <td><input type="number" name="quantity" value=""/></td>
</tr>
 
 
<tr>
   <td>Reorder</td>
   <td><input type="number" name="reorder" value=""/></td>
</tr>
<tr>
   <td>MaxQuantity</td>
   <td><input type="number" name="maxQuantity" value=""/></td>
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
<th>Description</th>
<th>Quantity</th>
<th>Reorder</th>
<th>MaxQuantity</th>
 
 
<c:forEach items="${ivo}" var="i">
<tr>
   <td><c:out value="${i.id}"></c:out></td>
   <td>${i.itemName}</td>
    <td>${i.itemDescription}</td>
     <td>${i.itemQuantity}</td>
      <td>${i.itemReorder}</td>
     <td>${i.itemMaxQuantity}</td>
      
</tr>
 
</c:forEach>
 
</table>
 
 
 
</body>
</html>