<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MC Squad</title>
  <!--   etiquetas de Bootstrap  -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/style.css">

  <!--   Iconos de footer -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>

<body id="bodyindex">

  <!--            Navbar          -->
  <nav>
  <%@include file="fijos/navbar.jsp" %>
  </nav>

  <!--    Cuerpo de la paginaa   -->

  <div class="card text-white" id="boycard1">
    <img class="card-img" src="resources/imagenes/minecraft5.png" alt="Card image"
      style="max-width: 70%; max-height: 70%; margin: auto;">
    <div class="card-img-overlay">
    </div>
  </div> <br> <br>

<!--    imagenes sin fondo   -->
<div class="container">
  <div class="row">
    <div class="col">
      <img src="resources/imagenes/sinfondo1.png" alt="Imagen 1" class="img-fluid" id="sinfondo1">
      <h2>Titulo 1</h2>
      <p>Texto pequeño 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam condimentum urna at risus vehicula, et condimentum quam convallis. Suspendisse potenti.</p>
    </div>
    <div class="col">
      <img src="resources/imagenes/sinfondo4.png" alt="Imagen 2" class="img-fluid" id="sinfondo2">
      <h3>Titulo 2</h3>
      <p>Texto pequeño 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam condimentum urna at risus vehicula, et condimentum quam convallis. Suspendisse potenti.</p>
    </div>
    <div class="col">
      <img src="resources/imagenes/sinfondo2.png" alt="Imagen 3" class="img-fluid" id="sinfondo3"> <br><br><br><br><br>
      <h3>Titulo 3</h3>
      <p>Texto pequeño 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam condimentum urna at risus vehicula, et condimentum quam convallis. Suspendisse potenti.</p>
    </div>
    <div class="col">
      <img src="resources/imagenes/logo1.png" alt="Imagen 4" class="img-fluid" id="sinfondo4"><br><br><br>
      <h3>Titulo 4</h3>
      <p>Texto pequeño 4 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam condimentum urna at risus vehicula, et condimentum quam convallis. Suspendisse potenti.</p>
    </div>
  </div>
</div>





  <!-- Espacio con título -->
  <div class="container mt-5">
    <div class="row">
      <div class="col">
        <h2 class="text-center">Descarga tu plugin de Minecraft</h2>
      </div>
    </div>
  </div>

  <!-- Cartas con los pluguins -->
  <div class="container">
    <div class="row">
      <div class="estructura">
        <div class="col">
          <!-- Cartas -->
          <div class="card-group">
            <div class="card">
              <img class="card-img-top" src="resources/imagenes/minecraft1.jpg" alt="Card image cap">
              <div class="card-body" id="cartas">
                <h5 class="card-title">Teleport Hubs: Centros de Teletransportacion</h5>
                <p class="card-text">Descripcion del pluguin</p>
              </div>
              <div class="card-footer">
                <a href="/path/to/your/file.pdf" download>Descargar el archivo</a>
              </div>
            </div>
            <div class="card">
              <img class="card-img-top" src="resources/imagenes/minecraft3.jpg" alt="Card image cap">
              <div class="card-body" id="cartas">
                <h5 class="card-title">ManHunt: Caza de Hombres</h5>
                <p class="card-text">Descripcion del Pluguin </p>
              </div>
              <div class="card-footer">
                <a href="/path/to/your/file.pdf" download>Descargar el archivo</a>
              </div>
            </div>
            <div class="card">
              <img class="card-img-top" src="resources/imagenes/minecraft4.jpg" alt="Card image cap">
              <div class="card-body" id="cartas">
                <h5 class="card-title">Assault Squad</h5>
                <p class="card-text">Descripcion del pluguin</p>
              </div>
              <div class="card-footer">
                <a href="/path/to/your/file.pdf" download>Descargar el archivo</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div><br><br><br>



  <!------------------ Footer ----------------->

  <footer>
  <%@include file="fijos/footer.jsp" %>
  </footer>




  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
    integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
    integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
    crossorigin="anonymous"></script>
</body>

</html>
