<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Regalo</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

	<div class="container">

		<h1>Bienvenido</h1>
		<hr />
		<div class="d-flex justify-content-between">
			<h2>Lista de Regalos:</h2>
			<a href="/registrar" class="btn btn-primary">Nuevo Regalo</a>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">Origen</th>
					<th scope="col">Destinatario</th>
					<th scope="col">Nombre</th>
					<th scope="col">Eliminar</th>
					<th scope="col">Editar</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach var="regalo" items="${listaRegalos}">

					<tr>
						<th><c:out value="${regalo.origen}"></c:out></th>
						<th><c:out value="${regalo.destinatario}"></c:out></th>
						<th><c:out value="${regalo.nombre}"></c:out></th>
						<th><a href="/eliminar/${regalo.id}" class="btn btn-danger"><i
								class="fa-solid fa-trash-can"></i></a></th>
						<th><a href="/editar/${regalo.id }" class="btn btn-success"><i
								class="fa-solid fa-pen-to-square"></i></a></th>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>