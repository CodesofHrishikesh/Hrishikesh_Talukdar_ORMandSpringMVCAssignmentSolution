<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
	
		<h1>List Of Customer</h1>
		<!--  JSP expression language  -->
		<%-- <p>${books }</p>
<p>${name }</p>
 --%>
	<div>
	
			<a href="/CustomerRelatinshipManagement/customer/showform">Add Customer</a>
			
			
		
	</div>
	<table class ="table">
	<tr>
		<th>firstname</th>
		<th>lastName</th>
		<th>email</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${customer }" var="customer">
		<tr>
			<td>${customer.firstname }</td>
			<td>${book.lastname }</td>
			<td>${book.email }</td>
			<td><a href="/CustomerRelationalManagement/customer/edit/${customer.id }">Edit</a>
			<a href="/CustomerRelationalManagement/customer/delete/${book.id }">Delete</a></td>
		</tr>
		
	</c:forEach>
	</table>
	</div>
</body>
