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
        <title>Flowers</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
    </head>
	<body>
		<div class="container" >
			<a href="/flowers" >All Flowers</a>
			<a href="/logout" >Logout</a>
			<h1>${flower.name}  </h1>
			<h5>Added By <span>${flower.user.userName}</span> </h5>
			<h5>Color <span>${flower.color}</span> </h5>
			<h5>Description  <span>${flower.description}</span></h5>
			<h5>Rating <span>${flower.rating}</span> </h5>
			<h5>is Prerennial <span>${flower.isPerennial ? 'Yes' : 'No'}</span> </h5>
			<a href="/flowers/${flower.id}/edit" class="btn btn-primary" >Edit</a>
			<form action="/flowers/${flower.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input class="btn btn-danger" type="submit" value="Delete">
			</form>
		</div>
	</body>
	</html>