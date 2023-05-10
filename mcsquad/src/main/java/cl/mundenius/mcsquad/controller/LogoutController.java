package cl.mundenius.mcsquad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.mundenius.mcsquad.interfaces.CRUD;
import cl.mundenius.mcsquad.modelo.Usuario;


@Controller
public class LogoutController {

	@Autowired
	private CRUD<Usuario> usuarioDao;
	
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
	    HttpSession session = request.getSession();
	    System.out.println("Se ha Deslogueado: "+ session.getAttribute("username"));
	    session.removeAttribute("username");
	    return new ModelAndView("confirmaciones/desloggeo");
	}
}
