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
        <title>Book Share</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
    </head>
	<body>
	<h1>Hi  </h1> <h2>${user.userName}</h2>
	</body>
	</html>