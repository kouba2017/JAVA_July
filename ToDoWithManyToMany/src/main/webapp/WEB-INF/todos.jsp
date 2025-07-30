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
        <title>TooDolist</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
    </head>

<body>

<div class="container mt-4">

<a href="/todos/create" class="btn btn-primary">Create Todo</a>

<form action="/todos/search" method="GET" class="mt-4">
<div class="input-group">
<input type="text" name="query" class="form-control" placeholder="search by title contains..">

<button type="submit" class="btn btn-primary">Search</button>
</div>
</form>
<table class="table table-striped">
<thead>
<tr>
<th>
Title 
</th>
<th>
Description 
</th>
<th>
Action 
</th>
</tr>
</thead>

<tbody>
<c:forEach var ="todo" items="${todos}">
<tr>
<td>
<a href="/todos/${todo.id}" ><c:out value="${todo.title}"></c:out></a>
</td>
<td>
<c:out value="${todo.description}"></c:out>
</td>
<td>
<a href="/todos/edit/${todo.id}" class="btn btn-success">Edit</a>
<a href="/todos/delete/${todo.id}" class="btn btn-danger">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>