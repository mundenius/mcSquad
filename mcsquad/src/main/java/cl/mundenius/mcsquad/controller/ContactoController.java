/**@author mundenius */
package cl.mundenius.mcsquad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**@category	Controller
 * @param	ContactoController
 * Mappeo a jsp correspondiente
 *  */
@Controller
public class ContactoController {

	@RequestMapping(value="/contacto")
	public ModelAndView contacto(HttpServletResponse response) throws IOException{
		return new ModelAndView("contacto");
	}
	
}
