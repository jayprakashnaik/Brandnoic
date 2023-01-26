<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>leads</title>
</head>

<body>

<h2 style="color:Pink;">All Leads</h2>
		<table border=10 , 1px solid black>
		<tr>
				<th style="background-color:Tomato;">First_Name</th>
				<th style="background-color:Tomato;">Last_Name</th>
				<th style="background-color:Tomato;">Email</th>
				<th style="background-color:Tomato;">Mobile</th>
				<th style="background-color:Tomato;">Delete</th>
				<th style="background-color:Orange;">Update</th>
				
		</tr>
		<c:forEach var = "lead" items="${leads}">
		<tr>
				<td style="background-color:Yellow;">${lead.firstName}</td>
				<td style="background-color:Yellow;">${lead.lastName }</td>
				<td style="background-color:Yellow;">${lead.email    }</td>
				<td style="background-color:Yellow;">${lead.mobile   }</td>
				
				<td><a href="delete?id=${lead.id}">Delete</a></td>
				<td><a href="update?id=${lead.id}">Update</a></td>				
		</tr>
      </c:forEach>
      
		</table>
		
</body>
</html>