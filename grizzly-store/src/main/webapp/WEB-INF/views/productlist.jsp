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


    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Grizzly Store</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
               
            </ul>
           <!--  <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form> -->
            
            <a href="/grizzly-store/logout"><button type="button" class="btn btn-secondary ml-4">Log Out</button></a>
            
        </div>
    </nav>




<div class="container mt-4">

<div class="row justify-content-end">

<a href="addproduct">
<input onclick="" class="btn btn-primary" type="button" value="Add Book">
</a>

</div>

	<div class="row">

	<div class="col-md-3 mt-4">
	
				<nav class="nav navbar-light bg-light">
					<a class="navbar-brand" href="#">Profile</a>
					 <!-- <a class="nav-link"href="#">Edit</a> -->
				</nav>

				<img src="" class="img-fluid mx-auto d-block mt-4" />

				<h4 class="text-center mt-4">${pageContext.request.userPrincipal.name}</h4>


	
	
	</div>
	
	
	<div class="col-md-9">
	
	

	<div class="container mt-4">
		
		<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Category</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="product" items="${products}">
  	
  	<c:url var="deletelink" value="/product/delete">
	<c:param name="id" value="${product.product_id}"></c:param>
	</c:url>
	
	
	<c:url var="updatelink" value="/product/update">
	<c:param name="id" value="${product.product_id}"></c:param>
	</c:url>
  	
  	<tr>
      <th scope="row">${product.product_id}</th>
      <td>${product.name}</td>
      <td>${product.category}</td>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td><a href="${updatelink}"><button type="button" class="btn btn-light">Update</button></a></td>
      <td><a href="${deletelink}"><button type="button" class="btn btn-light">Delete</button></a></td>
    </tr>
  	
  	</c:forEach>
    

  </tbody>
</table>

</div>
</div>
</div>


	</div>
</body>
</html>