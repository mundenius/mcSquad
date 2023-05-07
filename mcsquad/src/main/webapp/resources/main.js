/**
 * 
 */

 function mostrarCampos() {
			var seleccion = document.getElementById("tipo_usuario").value;
			var campos_cliente = document.getElementById("campos_cliente");
			var campos_administrativo = document.getElementById("campos_administrativo");
			if (seleccion == "cliente") {
				campos_cliente.style.display = "block";
				campos_administrativo.style.display = "none";
			} else if (seleccion == "administrativo") {
				campos_cliente.style.display = "none";
				campos_administrativo.style.display = "block";
			} else {
				campos_cliente.style.display = "none";
				campos_administrativo.style.display = "none";
			}
		}