<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Squad Login</title>
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

<!---- Formulario Login -->

<section class="container" id="login" >
    <div class="row">
      <div class="col-md-6">
        <form>
          <div class="form-group">
            <label for="nombre">Nombre de usuario:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Introduce tu nombre de usuario">
          </div>
          <div class="form-group">
            <label for="nombre">Correo electronico</label>
            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Introduce tu nombre de usuario">
          </div>
          <div class="form-group">
            <label for="contrasenia">Contraseña:</label>
            <input type="password" class="form-control" id="contrasenia" name="contrasenia" placeholder="Introduce tu contraseña">
          </div> <br>
          <button type="submit" class="btn btn-primary">Iniciar sesión</button>
        </form>
      </div>
      <div class="col-md-6">
        <img src="resources/imagenes/sinfondo6.jpeg" alt="Imagen de ejemplo" class="img-fluid">
      </div>
    </div>
  </section>


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