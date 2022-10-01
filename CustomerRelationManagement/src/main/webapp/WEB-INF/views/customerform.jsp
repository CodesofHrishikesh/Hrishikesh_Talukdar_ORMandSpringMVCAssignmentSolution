<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert customer details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>customer Information</h3>
<form action="/CustomerRelationalManagement/Customer/save" method="POST">
	<input type="hidden" name="id" value="${customer.id }"/>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">firstname</label>
    <input type="text"
    name="title" value="${customer.firstname }"
     class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">lastname</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="lastname"
    value="${customer.lastname }">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">email</label>
    <input type="text" name="email" 
    value="${customer.email }" class="form-control" id="exampleInputPassword1" name="email">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>