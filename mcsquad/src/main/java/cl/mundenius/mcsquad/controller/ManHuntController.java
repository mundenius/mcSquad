/**@author mundenius */
package cl.mundenius.mcsquad.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**@category	Controller
 * @param	ManHunt
 * Mappeo a jsp correspondiente
 *  */
@Controller
public class ManHuntController {

	@RequestMapping(value="/manhunt")
	public ModelAndView manHunt(HttpServletResponse response) throws IOException{
		return new ModelAndView("manhunt");
	}
}
