<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Create Flower</title>
</head>
<body>

<div class="container mt-4">
	<h1>Edit Flower</h1>
	
	<form:form method="post" modelAttribute="flower" action="/flowers/${flower.id}/edit">
	<input type="hidden" name="_method" value="put">
	<div>
	<form:label path="name"> Name</form:label>
	<form:input type="text" path="name" class="form-control"  ></form:input>
	<form:errors path="name" class="badge text-danger" ></form:errors>
	</div>
	<div>
	<form:label path="color"> Color</form:label>
	<form:input type="text" path="color" class="form-control"  ></form:input>
	<form:errors path="color" class="badge text-danger" ></form:errors>
	</div>
	<div>
	<form:label path="isPerennial"> isPerennial</form:label>
	<form:checkbox path="isPerennial" class="form-check-input"  />
	<form:errors path="isPerennial" class="badge text-danger" ></form:errors>
	</div>
	<div>
	<form:label path="rating"> Rating</form:label>
	<form:input type="number" path="rating" class="form-control"></form:input>
	<form:errors path="rating" class="badge text-danger" ></form:errors>
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