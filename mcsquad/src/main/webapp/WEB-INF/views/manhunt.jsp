<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manhunt: Caza de Hombres</title>
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
	<nav>
		<%@include file="fijos/navbar.jsp"%>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col">
				<h2>ManHunt: Caza de Hombres</h2>
				<p>Este plugin te permite asignar un rol de cazador a ti y a tus
					amigos. Cada cazador tendra una brujula que podra usar para hacerle
					seguimiento a cualquier jugador en survival. Tiene la opcion de
					desactivar el seguimiento en el Nether, y cada vez que se hace
					click en la brujula, se hace seguimiento a un jugador distinto.
					También esta incluido el comanod "/cleanstart", que te permitirá
					partir desde cero, pero asegurandose de que se le restituyan las
					brujulas a los cazadores.</p>
				<div class="card-group">
					<div class="card">
							<img class="card-img-top"
								src="resources/imagenes/minecraft1.jpg" alt="Card image cap">
						<div class="card-body" id="cartas">
							<h3 class="card-title">MANHUNT</h3>
							<p class="card-text">Caza a tus amigos, mientras intentan
								conseguir diamantes o matar al dragón.</p>
						</div>
						<div class="card-footer">
							<a href="resources/plugins/ManHunt.jar" download>Descarga el archivo</a> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>
		<%@include file="fijos/footer.jsp"%>
	</footer>

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