<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assault Squad</title>
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

	<div class="container mt-4">
		<div class="row">
			<div class="col-md-9">
				<h2 class="display-3">
					<b> Assault Squad: Sobrevive</b>
				</h2>
				<p class="lead">Este plugin esta pensado como una adaptacion del
					modo asalto del Battlefield o el Call of Duty. La principal
					diferencia es que la cantidad de equipos es ilimitada, por ende
					solo el equipo que genera mas kill ganará. Consiste en tres rondas
					que duran 5 minutos cada una; al inicio de cada ronda los jugadores
					serán teletransportados a un punto de spawn que hayan elegido en
					conjunto. Se asignara armadura, armas y municiones a todos los
					jugadores, y se dará comienzo al juego.</p>
				<div id="carouselExampleControls" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100"
								src="resources/imagenes/assaultsquad/comingsoon.jpg"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="resources/imagenes/assaultsquad/comingsoon.jpg"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="resources/imagenes/assaultsquad/comingsoon.jpg"
								alt="Third slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="resources/imagenes/assaultsquad/comingsoon.jpg"
								alt="Fourth slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="resources/imagenes/assaultsquad/comingsoon.jpg"
								alt="Fifth slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Anterior</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Siguiente</span>
					</a>
				</div>
				<br>
				<br>
				<div class="card-group">
					<div class="card">
						<div class="card-body" id="cartas">
							<h3 class="card-title display-4">
								<b> Assault Squad </b>
							</h3>
							<p class="card-text lead">Compite con tus amigos por ver
								quien hace mas kills!</p>
						</div>
						<div class="card-footer">
							<a class="btn btn-secondary" href="#" download>Pronto..</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<br> <br>
				<div>
					<section>
						<h3>
							<b> Sobre el Proyecto </b>
						</h3>
						<dl>
							<dt>Creado</dt>
							<dd>
								<span>1 de Mayo 2023</span>
							</dd>
							<dt>Updated</dt>
							<dd>
								<span>10 de Mayo 2023</span>
							</dd>
						</dl>
					</section>
					<section id="versions-summary">
						<h3>
							<b>Game Versions</b>
						</h3>
						<use href="/images/sprite.svg#icon-small-chevron-right"></use>

						<ul class="links" id="project-versions">
							<li id="version-item"><a>1.19.2</a></li>
							<li id="version-item"><a>1.19.1</a></li>
							<li id="version-item"><a>1.19</a></li>
							<li id="version-item"><a>1.18.2</a></li>
							<li class="extra">+ 38 Versions</li>
						</ul>
					</section>
					<section id="project-categories">
						<h3>
							<b>Categories</b>
						</h3>
						<ul class="links">
							<li><a>Juego por Rondas</a></li>
							<li><a>Nuevos Comandos</a></li>
							<li><a>Funcionalidad</a></li>
							<li><a>Equipos</a></li>
							<li><a>Plugin</a></li>
						</ul>
					</section>
					<section>
						<h3>
							<b>Main File</b>
						</h3>
						<div class="file-card">
							<h5 title="AssaultSquad 1.19.2">Assault Squad</h5>
							<ul class="file-details-list">
								<li><span class=" channel-tag release">Release Soon</span></li>
							</ul>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>

	<footer>
		<%@include file="fijos/footer.jsp"%>
	</footer>


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