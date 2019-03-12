<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>

<body>
	<div class="container mt-4">
		
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Category</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="product" items="${products}">
  	
  	<c:url var="deletelink" value="/product/delete">
	<c:param name="id" value="${product.product_id}"></c:param>
	</c:url>
	
	
	<c:url var="updatelink" value="/book/update">
	<c:param name="id" value="${product.product_id}"></c:param>
	</c:url>
  	
  	<tr>
      <th scope="row">${product.product_id}</th>
      <td>${product.name}</td>
      <td>${product.category}</td>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td><a href="${updatelink}">Update</a></td>
      <td><a href="${deletelink}">Delete</a></td>
    </tr>
  	
  	</c:forEach>
    

  </tbody>
</table>

<a href="addproduct">
<input onclick="" class="btn btn-primary" type="button" value="Add Book">
</a>

<a href="<c:url value="j_spring_security_logout"/>">Logout</a>

	</div>
</body>
</html>