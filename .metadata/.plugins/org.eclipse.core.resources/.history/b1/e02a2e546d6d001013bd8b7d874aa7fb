<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<title>List Of Todos</title>
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
<c:out value="${todo.title}"></c:out>
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