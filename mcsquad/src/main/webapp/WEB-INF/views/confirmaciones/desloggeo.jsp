<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5; url=<c:url value='/'/>">

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
<title>Confirmacion</title>
</head>
<body id="bodyindex">

	<!-- navbar -->

	<%@include file="../fijos/navbar.jsp"%>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h1 class="card-title text-center mb-4">¡Se ha desloggeado
							con éxito!</h1>
						<p class="card-text text-center">Será redireccionado al Inicio
							automáticamente</p>
						<div class="text-center mt-4">
							<a href="<c:url value='/'/>" class="btn btn-primary">Volver a
								inicio</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer  -->
	<footer class="fixed-bottom">
		<%@include file="../fijos/footer.jsp"%>
	</footer>

	<script src="../resources/main.js"></script>
	<!-- Enlace al archivo JavaScript de jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

	<!-- Enlace al archivo JavaScript de Bootstrap -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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