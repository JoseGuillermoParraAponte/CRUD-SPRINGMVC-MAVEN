<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejemplo de JdbcTemplate</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="row">
			<h1>Registros de toda la BBDD</h1>
			<br>
			<p>
				<a href="<c:url value="FormularioDeRegistro"></c:url>"
					class="btn btn-primary"> <span class="glyphicon glyphicon-plus"></span>Agregar
				</a>
				<a href="<c:url value="index"></c:url>"
				class="btn btn-primary">Inicio
			</a>
			</p>

			<table class="table table-bordered table-scriped table-hover">

				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRES</th>
						<th>APELLIDOS</th>
						<th>EDAD</th>
						<th>E-MAIL</th>
						<th>DIRECCIÓN</th>
						<th>GÉNERO</th>
						<th>LIBROS</th>
						<th>DEPORTES</th>
						<th>PELICULAS</th>
						<th>VIDEO JUEGOS</th>
						<th>OTROS</th>
						<th>PAÍS</th>
						<th>ACCIONES</th>


					</tr>
				</thead>
				<tbody>
					<c:forEach items="${datos}" var="dato">

						<tr>
							<td><c:out value="${dato.ID}"></c:out></td>
							<td><c:out value="${dato.NOMBRES}"></c:out></td>
							<td><c:out value="${dato.APELLIDOS}"></c:out></td>
							<td><c:out value="${dato.EDAD}"></c:out></td>
							<td><c:out value="${dato.EMAIL}"></c:out></td>
							<td><c:out value="${dato.DIRECCION}"></c:out></td>
							<td><c:out value="${dato.GENERO}"></c:out></td>
							<td><c:out value="${dato.LIBROS}"></c:out></td>
							<td><c:out value="${dato.DEPORTES}"></c:out></td>
							<td><c:out value="${dato.PELICULA}"></c:out></td>
							<td><c:out value="${dato.VIDEOJUEGOS}"></c:out></td>
							<td><c:out value="${dato.OTROS}"></c:out></td>
							<td><c:out value="${dato.PAIS}"></c:out></td>
							<td><a href="<c:url value="editar?ID=${dato.ID}"></c:url>">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a> <a href="<c:url value="delete?ID=${dato.ID}"></c:url>"> <span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>

		</div>


	</div>


</body>
</html>