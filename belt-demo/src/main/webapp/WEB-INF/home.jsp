<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. --> 
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!-- Formatting (dates) --> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
    <!-- form:form -->
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- for rendering errors on PUT routes -->
    <%@ page isErrorPage="true" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Flowres</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
    </head>
	<body>
		<div class="container" >
			<h1>Welcome  </h1> <h2>${user.userName}</h2>
			<h3>All Flowers</h3>
			<a href="/myFlowers" >Your Flowers</a>
			<a href="/logout" >Logout</a>
			<table class="table table-striped">
				<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Color</th>
					<th>Added By</th>
					<th>Action</th>
				</tr>
				</thead>

				<tbody>
					<c:forEach var ="flower" items="${flowers}">
						<tr>
						<td>${flower.id}</td>
						<td>
						<c:out value="${flower.name}"></c:out>
						</td>
						<td>${flower.color}</td>
						<td>${flower.user.userName}</td>
						
						<td>
						<a href="/flowers/${flower.id}" class="btn btn-success">View</a>
						</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/flowers/new" >Add Flower</a>

		</div>
	</body>
	</html>