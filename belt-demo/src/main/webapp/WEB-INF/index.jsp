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
        <title>Login & Register</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        
    </head>
	<body>
	<div class="container mt-4">
<h1>Create User</h1>

<form:form method="post" modelAttribute="newUser" action="/register">
<div>
<form:label path="userName"> name</form:label>
<form:input type="text" path="userName" class="form-control"></form:input>
<form:errors path="userName" class="badge text-danger" ></form:errors>
</div>
<div>
<form:label path="email"> Email</form:label>
<form:input type="email" path="email" class="form-control"></form:input>
<form:errors path="email" class="badge text-danger" ></form:errors>
</div>
<div>
<form:label path="password"> Passsword</form:label>
<form:input type="password" path="password" class="form-control"></form:input>
<form:errors path="password" class="badge text-danger" ></form:errors>
</div>
<div>
<form:label path="confirm"> Password Confirm</form:label>
<form:input type="password" path="confirm" class="form-control"></form:input>
<form:errors path="confirm" class="badge text-danger" ></form:errors>
</div>

<button type="submit" class="btn btn-primary" >Register</button>
</form:form>
<h1>Login User</h1>

<form:form method="post" modelAttribute="newLogin" action="/login">

<div>
<form:label path="email"> Email</form:label>
<form:input type="email" path="email" class="form-control"></form:input>
<form:errors path="email" class="badge text-danger" ></form:errors>
</div>
<div>
<form:label path="password"> Passsword</form:label>
<form:input type="password" path="password" class="form-control"></form:input>
<form:errors path="password" class="badge text-danger" ></form:errors>
</div>


<button type="submit" class="btn btn-primary" >Register</button>
</form:form>
</div>
	</body>
	</html>