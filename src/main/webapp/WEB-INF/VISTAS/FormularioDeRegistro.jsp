<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de registro</title>
<link rel="styLesheet" type="text/css"
	href="${pageContext.request.contextPath}/RECURSOS/css/estilos.css">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="wrap">
		<h1>Formulario de Registro</h1>

		<form:form action="procesarFormulario" modelAttribute="persona"
			class="formulario">
			<p>
				<form:label path="nombre">Nombres:</form:label>
				<form:input path="nombre" placeholder="Escribe tus nombres" />
			</p>

			<p>
				<form:label path="apellidos">Apellidos:</form:label>
				<form:input path="apellidos" placeholder="Escribe tus apellidos" />
			</p>

			<p>
				<form:label path="edad">Edad:</form:label>
				<form:input path="edad" placeholder="Escribe tu edad" />
			</p>

			<p>
				<form:label path="email">E-Mail:</form:label>
				<form:input path="email" placeholder="Escribe tu email" />
			</p>

			<p>
				<form:label path="direccion">Dirección:</form:label>
				<form:textarea path="direccion" placeholder="Escribe tu dirección" />
			</p>

			<p>
				<form:label path="genero">Género:</form:label>
				<form:radiobuttons path="genero" items="${generoLista}" />
			</p>

			<p>
				<form:label path="intereses">Intereses:</form:label>
				<form:checkboxes items="${interesesLista}" path="intereses" />
			</p>

			<p>
				<form:label path="pais">País</form:label>
				<form:select path="pais">
					<form:option value=" ">Seleccione....</form:option>
					<form:options items="${paisLista}" />
				</form:select>
			</p>
			<br />
			<hr />

			<input type="submit" value="Enviar" />
			<input type="reset" value="Restaurar formulario">

		</form:form>


	</div>
</body>
</html>