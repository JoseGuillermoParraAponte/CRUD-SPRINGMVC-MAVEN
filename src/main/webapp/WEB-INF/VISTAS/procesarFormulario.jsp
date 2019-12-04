<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Procesar Formulario</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="styLesheet" type="text/css"
	href="${pageContext.request.contextPath}/RECURSOS/css/miestilo.css">
</head>
<body>

	<div class="wrap">

		<h1>Confirmación de los datos</h1>
		
		<div class="marco">
		<p>
		<ul>
			<li>Nombres: ${persona.nombre}</li>
			<li>Apellidos: ${persona.apellidos}</li>
			<li>Edad: ${persona.edad}</li>
			<li>E-mail: ${persona.email}</li>
			<li>Dirección: ${persona.direccion}</li>
			<li>Sexo: ${persona.genero}</li>
			<li>Intereses:
				<ul style="list-style-type: none" >
					<c:forEach items="${persona.intereses}" var="interes">
						<li  style="padding-left: 20px"><c:out value="${interes}" /></li>
					</c:forEach>
				</ul>
			</li>
			<li>País: ${persona.pais}</li>
		</ul>
		</p>
		<br />
		<hr />
		<br />
		<div>
			<p>
				<a href="<c:url value="registrarme"></c:url>"
					class="btn btn-primary"> <span class="glyphicon glyphicon-plus"></span>Registrarme
				</a>
			</p>
		</div>
		<div>
			<a href="FormularioDeRegistro">Volver al formulario de registro</a>
		</div>
		<div>
			<a href="index">Volver a la página principal del sitio
				web</a>
		</div>
	</div>
	</div>
</body>
</html>