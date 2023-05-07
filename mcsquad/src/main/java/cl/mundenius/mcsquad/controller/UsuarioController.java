package cl.mundenius.mcsquad.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.mundenius.mcsquad.dao.ImplAdminDao;
import cl.mundenius.mcsquad.dao.ImplClienteDao;
import cl.mundenius.mcsquad.dao.ImplUsuarioDao;
import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Administrativo;
import cl.mundenius.mcsquad.modelo.Cliente;
import cl.mundenius.mcsquad.modelo.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private ImplAdminDao adminDao;
	
	@Autowired
	private ImplClienteDao cliDao;
	
	@Autowired
	
	private ImplUsuarioDao usuarioDao;
	
	@RequestMapping(value="/crearUsuario", method= RequestMethod.GET)
	public ModelAndView crearUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a crearUsuario.jsp");
		return new ModelAndView("usuarios/crearUsuario");
	}
	
	@RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
	public ModelAndView formUsuario(@RequestParam("tipo_usuario") String tipoUsuario, 
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
	
	@RequestMapping(value="/listarUsuarios", method= RequestMethod.GET)
	public String mostrarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuarioDao.mostrarUsuarios();
	    System.out.println("listaUsuarios creada, pre insercion a JSP");
		model.addAttribute("usuarios", listaUsuarios);
	    return "usuarios/listarUsuarios";
    }
}
