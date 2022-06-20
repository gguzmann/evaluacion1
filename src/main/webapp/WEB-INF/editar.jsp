<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

</head>
<body>

	<div class="container">

		<h1>Editar regalo:</h1>
		
		<c:out value="${msgError }"></c:out>
		<form:form action="/editar/validar/${regalo.id}" method="post"
			modelAttribute="regalo">
			
			<div class="form-group">
			<form:label path="origen">Origen:</form:label>
			<form:input class="form-control" path="origen" />
			</div>

			<div class="form-group">
			<form:label path="destinatario">Destinatario:</form:label>
			<form:input class="form-control" path="destinatario" />
			</div>
			
			<div class="form-group">
			<form:label path="nombre">Nombre:</form:label>
			<form:input class="form-control" path="nombre" />
			</div>
			
			<div class="form-group">
			<form:label path="telefono">Telefono:</form:label>
			<form:input class="form-control" type="number" path="telefono" />
			</div>
			
			<br>
			<input type="submit" class="btn btn-primary" value="registrar" />
			
			
		</form:form>

	</div>

</body>
</html>