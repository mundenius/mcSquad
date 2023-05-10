<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contacto</title>
<!--   etiquetas de Bootstrap  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/style.css">

<!--   Iconos de footer -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<body id="bodyindex">

	<!--            Navbar          -->
	<nav>
	<%@include file="fijos/navbar.jsp" %>
	</nav>
	<br>


	<!-- cuerpo de formulario de Contacto-->

	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<form>
					<div class="mb-3">
						<label for="name" class="form-label">Nombre</label> <input
							type="text" class="form-control" id="name"
							placeholder="Ingrese su nombre">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Correo electrónico</label> <input
							type="email" class="form-control" id="email"
							placeholder="Ingrese su correo electrónico">
					</div>
					<div class="mb-3">
						<label for="message" class="form-label">Mensaje</label>
						<textarea class="form-control" id="message" rows="5"
							placeholder="Ingrese su mensaje"></textarea>
					</div>
					<button type="submit" class="btn btn-success">Enviar</button>
				</form>
			</div>
			<div class="col-lg-6">
				<img src="resources/imagenes/sinfondo5.png" alt="Imagen" class="img-fluid">
			</div>
		</div>
	</div>


	<!------------------ Footer ----------------->

	<footer class="bottom">
		<%@include file="fijos/footer.jsp"%>
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