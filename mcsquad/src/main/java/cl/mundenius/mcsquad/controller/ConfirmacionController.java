package cl.mundenius.mcsquad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/confirmaciones")
public class ConfirmacionController {

	@RequestMapping(value="/crearUsuario", method= RequestMethod.GET)
	public ModelAndView createUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a confirmaciones/crearUsuario.jsp");
		return new ModelAndView("confirmaciones/usuarioCreado");
	}
	
	@RequestMapping(value="/editarUsuario", method= RequestMethod.GET)
	public ModelAndView updateUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a editarUsuario.jsp");
		return new ModelAndView("confirmaciones/usuarioEditado");
	}
	
	@RequestMapping(value="/eliminarUsuario", method= RequestMethod.GET)
	public ModelAndView deleteUsuarioView(HttpServletResponse response) throws IOException{
		System.out.println("Redireccionando a eliminarUsuario.jsp");
		return new ModelAndView("confirmaciones/usuarioEliminado");
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
	    return new ModelAndView("confirmaciones/desloggeo");
	}
}
