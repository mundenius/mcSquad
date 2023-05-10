/**@author mundenius */
package cl.mundenius.mcsquad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**@category	Controller
 * @param	TeleportHubController
 * Mapping a jsp correspondiente
 *  */
@Controller
public class TeleportHubController {

	@RequestMapping(value="/teleporthub")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("teleporthub");
	}
}
