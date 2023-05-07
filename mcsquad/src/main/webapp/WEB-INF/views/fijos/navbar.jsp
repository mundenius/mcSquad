<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<nav class="navbar navbar-expand-lg" id="navbar">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value='/'/>" class="nav-link"><img src="<c:url value='/resources/imagenes/logom.png'/>" alt="Logo" id="logo"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a href="<c:url value='/'/>" class="nav-link"><b>Home</b></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
            aria-expanded="false">
            <b>Descargas</b> 
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="<c:url value='/manhunt'/>" class="dropdown-item" >ManHunt</a></li>
            <li><a href="<c:url value='/teleporthub'/>" class="dropdown-item" >Teleport Hub</a></li>
            <li><a href="<c:url value='/assaultsquad'/>" class="dropdown-item">Assault Squad</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a href="<c:url value='/contacto'/>" class="nav-link"> <b>Contacto</b></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
            aria-expanded="false">
            <b>Usuarios</b> 
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a href="<c:url value='/usuarios/listarUsuarios'/>" class="dropdown-item" >Lista de Usuarios</a></li>
            <li><a href="<c:url value='/usuarios/editarUsuario'/>" class="dropdown-item" >Editar Usuario</a></li>
            <li><a href="<c:url value='/usuarios/eliminarUsuario'/>" class="dropdown-item">Eliminar Usuario</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <%-- Verifica si el usuario está registrado en la sesión actual --%>
          <% String username = (String) session.getAttribute("username"); %>
          <% if (username != null) { %>
            <%-- Si el usuario está registrado, muestra su nombre de usuario y el botón de logout --%>
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown"
              aria-expanded="false">
              <b><%=username%></b>
            </a>
            <ul class="dropdown-menu" aria-labelledby="userDropdown">
              <li>
                <form action="logout" method="POST">
                  <button id="btnlogout" class="btn btn-sm">Logout</button>
				</form>
                <ul>
                <li><a href="<c:url value='/usuarios/editarUsuario'/>" class="dropdown-item" >Editar Usuario</a></li>
            	<li><a href="<c:url value='/usuarios/eliminarUsuario'/>" class="dropdown-item">Eliminar Usuario</a></li>
                </ul>
                   <% } else { %>
            <%-- Si el usuario no está registrado, muestra el botón de login/registro --%>
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown"
              aria-expanded="false">
              <b>Login/Registro</b>
            </a>
            <ul class="dropdown-menu" aria-labelledby="userDropdown">
              <li><a href="<c:url value='/login'/>" class="dropdown-item">Login</a></li>
              <li><a href="<c:url value='/usuarios/crearUsuario'/>" class="dropdown-item">Registro</a></li>
            </ul>
          <% } %>
        </li>
      </ul>
      </ul>
    </div>
  </div>
</nav>
<c:if test="${not empty message}">
							<div id="popupbadlogin" class="alert alert-dismissible alert-danger d-flex">
							  <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
							    ${message}
							</div>
						</c:if>