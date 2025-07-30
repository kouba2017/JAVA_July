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
        <title>Edit Todo</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
    </head>
    <body>
    
<div class="container mt-4">
<h1>Edit ToDo</h1>

<form:form method="post" modelAttribute="todo" action="/todos/edit/${todoOne.id}">
	<input type="hidden" name="_method" value="PUT" >
	<div>
	<form:label path="title"> Title</form:label>
	<form:input type="text" path="title" class="form-control" value="${todoOne.title}" ></form:input>
	<form:errors path="title" class="badge text-danger" ></form:errors>
	</div>

	<div>
	<form:label path="description"> Description</form:label>
	<form:textarea  path="description" class="form-control"></form:textarea>
	<form:errors path="description" class="badge text-danger" ></form:errors>
	</div>

<button type="submit" class="btn btn-primary" >Edit</button>
</form:form>

</div>
    </body>
   </html>
