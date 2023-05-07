<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Usuarios</title>
<!--   etiquetas de Bootstrap  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../resources/style.css">

<!--   Iconos de footer -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
	<!--            Navbar          -->
	<nav>
		<%@include file="../fijos/navbar.jsp"%>
	</nav>

	<div class="container">
		<h1 class="mt-4">Lista de usuarios</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID Usuario</th>
					<th>Username</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Fecha Nacimiento</th>
					<th>Clave</th>
					<th>RUN</th>
					<th>ID Administrativo</th>
					<th>Área</th>
					<th>ID Cliente</th>
					<th>Teléfono</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.idUsuario}</td>
						<td>${usuario.username}</td>
						<td>${usuario.nombre}</td>
						<td>${usuario.apellido}</td>
						<td>${usuario.fechaNacimiento}</td>
						<td>${usuario.clave}</td>
						<td>${usuario.run}</td>
						<c:choose>
							<c:when test="${usuario.getClass().getName().equals('cl.mundenius.mcsquad.modelo.Administrativo')}">
								<td>${usuario.idAdmin}</td>
								<td>${usuario.area}</td>
								<td></td>
								<td></td>
								<td></td>
							</c:when>
							<c:when test="${usuario.getClass().getName().equals('cl.mundenius.mcsquad.modelo.Cliente')}">
								<td></td>
								<td></td>
								<td></td>
								<td>${usuario.idCliente}</td>
								<td>${usuario.telefono}</td>
								<td>${usuario.email}</td>
							</c:when>
							<c:otherwise>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!------------------ Footer ----------------->

	<footer>
		<%@include file="../fijos/footer.jsp"%>
	</footer>

	<script src="../resources/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
		integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
		integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
		crossorigin="anonymous"></script>
</body>
</html>