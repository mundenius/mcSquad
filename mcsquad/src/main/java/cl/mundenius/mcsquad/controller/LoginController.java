package cl.mundenius.mcsquad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {

	@RequestMapping(value="/login")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
}
