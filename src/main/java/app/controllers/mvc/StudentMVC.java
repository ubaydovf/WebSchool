package app.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentMVC {

	@RequestMapping("/view")
	String home(ModelMap modal) {
//        System.out.println("WE ARE INSIDE MVC CONTROLLER");
        modal.addAttribute("title","List of students");
		return "try";
	}

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

}
