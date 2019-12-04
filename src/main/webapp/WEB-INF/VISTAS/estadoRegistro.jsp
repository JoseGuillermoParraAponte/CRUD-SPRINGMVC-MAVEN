<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estado del registro</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="styLesheet" type="text/css"
	href="${pageContext.request.contextPath}/RECURSOS/css/estilos.css">
</head>
<body>
<div class="wrap">
	<h1>Felicidades....te haz registrado con éxito!!!</h1>
	<br />
	<div>
		<p>
			<a href="<c:url value="mostrarConsulta"></c:url>"
				class="btn btn-primary"> <span class="glyphicon glyphicon-plus"></span>Mostrar Registros
			</a>
			<a href="<c:url value="index"></c:url>"
				class="btn btn-primary">Inicio
			</a>
		</p>
	</div>
	</div>
</body>
</html>