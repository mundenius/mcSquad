/**@author mundenius */
package cl.mundenius.mcsquad.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.mundenius.mcsquad.dao.ImplAdminDao;
import cl.mundenius.mcsquad.dao.ImplClienteDao;
import cl.mundenius.mcsquad.dao.ImplUsuarioDao;
import cl.mundenius.mcsquad.modelo.Administrativo;
import cl.mundenius.mcsquad.modelo.Cliente;
import cl.mundenius.mcsquad.modelo.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	
	/**@category	Implementacion DAO
	 * @param	Usuario, Administrativo y Cliente
	 * Se utiliza la anotacion Autowired de Spring MVC */
	@Autowired
	private ImplAdminDao adminDao;
	
	@Autowired
	private ImplClienteDao cliDao;
	
	@Autowired
	private ImplUsuarioDao usuarioDao;
	
	
	/**@category	Mapping
	 * @param	Crear Usuario
	 * Despliegue de vista, y procesamiento del formulario */
	@RequestMapping(value="/crearUsuario", method= RequestMethod.GET)
	public ModelAndView createUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a crearUsuario.jsp");
		return new ModelAndView("usuarios/crearUsuario");
	}
	
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
	public ModelAndView formCreateUsuario(@RequestParam("tipo_usuario") String tipoUsuario, 
	                                     @RequestParam("username") String username,
	                                     @RequestParam("nombre") String nombre,
	                                     @RequestParam("apellido") String apellido,
	                                     @RequestParam("fechanacimiento") String fechaNacimiento,
	                                     @RequestParam("run") String run,
	                                     @RequestParam("clave") String clave,
	                                     @RequestParam(value = "telefono", required = false) String telefono,
	                                     @RequestParam(value = "email", required = false) String email,
	                                     @RequestParam(value = "area", required = false) String area) {
	    ModelAndView mv = new ModelAndView();

	    // Verificar el valor del campo "tipo_usuario"
	    if (tipoUsuario.equals("cliente")) {
	        // Invocar al método para guardar los datos en la tabla de clientes
	        Cliente cli = new Cliente();
	        cli.setUsername(username);
	        cli.setNombre(nombre);
	        cli.setApellido(apellido);
	        cli.setFechaNacimiento(fechaNacimiento);
	        cli.setClave(clave);
	        cli.setRun(run);
	        cli.setTelefono(telefono);
	        cli.setEmail(email);
	        
	        cliDao.crearUsuario(cli);
	    } else if (tipoUsuario.equals("administrativo")) {
	        // Invocar al método para guardar los datos en la tabla de administrativos
	        Administrativo admin = new Administrativo();
	        admin.setUsername(username);
	        admin.setNombre(nombre);
	        admin.setApellido(apellido);
	        admin.setFechaNacimiento(fechaNacimiento);
	        admin.setClave(clave);
	        admin.setRun(run);
	        admin.setArea(area);
	        
	        adminDao.crearUsuario(admin);
	    }

	    mv.setViewName("redirect:listarUsuarios");
	    return mv;
	}
	
	
	/**@category	Mapping
	 * @param	Listar Usuarios
	 * Despliegue de los usuarios en el archivo jsp */
	
	@RequestMapping(value="/listarUsuarios", method= RequestMethod.GET)
	public String readUsuarios(@RequestParam(value = "filtro", required = false) String filtro, Model model) {
		 List<Usuario> listaUsuarios = new ArrayList<>();
		 List<Administrativo> listaAdmin;
		 List<Cliente> listaCliente;
		    if (filtro != null) {
		        switch (filtro) {
		            case "clientes":
		                listaCliente = cliDao.mostrarUsuarios();
		                listaUsuarios.addAll(listaCliente);
		                System.out.println(filtro);
		                break;
		            case "administrativos":
		                listaAdmin = adminDao.mostrarUsuarios();
		                listaUsuarios.addAll(listaAdmin);
		                System.out.println(filtro);
		                break;
		            default:
		                listaUsuarios = usuarioDao.mostrarUsuarios();
		                System.out.println("default");
		                break;
		        }
		    } else {
		        listaUsuarios = usuarioDao.mostrarUsuarios();
                System.out.println("else");

		    }
		    System.out.println("listaUsuarios creada, pre insercion a JSP");
		    System.out.println(listaUsuarios);
		    model.addAttribute("usuarios", listaUsuarios);
		    return "usuarios/listarUsuarios";
    }
	
	
	
	/**@category	Mapping
	 * @param	Editar Usuario
	 * Despligue de vista y procesamiento de formulario jsp */
	@RequestMapping(value="/editarUsuario", method= RequestMethod.GET)
	public ModelAndView updateUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a editarUsuario.jsp");
		return new ModelAndView("usuarios/editarUsuario");
	}
	
	@RequestMapping(value = "/editarUsuario", method = RequestMethod.POST)
	public ModelAndView formUpdateUsuario(@RequestParam("tipo_usuario") String tipoUsuario, 
	                                     @RequestParam("username") String username,
	                                     @RequestParam("nombre") String nombre,
	                                     @RequestParam("apellido") String apellido,
	                                     @RequestParam("fechanacimiento") String fechaNacimiento,
	                                     @RequestParam("run") String run,
	                                     @RequestParam("clave") String clave,
	                                     @RequestParam(value = "telefono", required = false) String telefono,
	                                     @RequestParam(value = "email", required = false) String email,
	                                     @RequestParam(value = "area", required = false) String area) {
	    ModelAndView mv = new ModelAndView();

	    // Verificar el valor del campo "tipo_usuario"
	    if (tipoUsuario.equals("cliente")) {
	        // Invocar al método para guardar los datos en la tabla de clientes
	        Cliente cli = new Cliente();
	        cli.setUsername(username);
	        cli.setNombre(nombre);
	        cli.setApellido(apellido);
	        cli.setFechaNacimiento(fechaNacimiento);
	        cli.setClave(clave);
	        cli.setRun(run);
	        cli.setTelefono(telefono);
	        cli.setEmail(email);
	        
	        cliDao.editarUsuario(cli);
	    } else if (tipoUsuario.equals("administrativo")) {
	        // Invocar al método para guardar los datos en la tabla de administrativos
	        Administrativo admin = new Administrativo();
	        admin.setUsername(username);
	        admin.setNombre(nombre);
	        admin.setApellido(apellido);
	        admin.setFechaNacimiento(fechaNacimiento);
	        admin.setClave(clave);
	        admin.setRun(run);
	        admin.setArea(area);
	        
	        adminDao.editarUsuario(admin);
	    }

	    mv.setViewName("redirect:listarUsuarios");
	    return mv;
	}
	
	
	/**@category	Mapping
	 * @param	Eliminar Usuario 
	 * Despligue y procesamiento del formulario jsp. */
	@RequestMapping(value="/eliminarUsuario", method= RequestMethod.GET)
	public ModelAndView deleteUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a eliminarUsuario.jsp");
		return new ModelAndView("usuarios/eliminarUsuario");
	}
	
	@RequestMapping(value = "/eliminarUsuario", method = RequestMethod.POST)
	public ModelAndView formDeleteUsuario(@RequestParam("tipo_usuario") String tipoUsuario, 
	                                     @RequestParam("run") String run,
	                                     @RequestParam("clave") String clave) {
	    ModelAndView mv = new ModelAndView();

	    try {
	    	System.out.println("dentro try catch controller");
	    	if (tipoUsuario.equals("cliente")) {
	            System.out.println("dentro de condicional cliente");
	    		Cliente cli = new Cliente();
	            cli.setClave(clave);
	            cli.setRun(run);
	            
	            cliDao.eliminarUsuario(cli);
	        } else if (tipoUsuario.equals("administrativo")) {
	            System.out.println("dentro de condicional admin");
	        	Administrativo admin = new Administrativo();
	            admin.setClave(clave);
	            admin.setRun(run);
	            
	            adminDao.eliminarUsuario(admin);
	        }

	        mv.setViewName("redirect:listarUsuarios");
	        return mv;
	    } catch (Exception e) {
	        // Configuracion  del mensaje de error
	        String errorMessage = "Error al eliminar usuario: la contraseña y el run no coinciden.";
	        
	        // Se agrega el mensaje de error como objeto al MAV
	        mv.addObject("error", errorMessage);
	        mv.setViewName("redirect:listarUsuarios");
	        return mv;
	    }
	}
}
