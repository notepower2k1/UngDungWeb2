package DemoSpringMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("home/")
public class HomeController {
	@RequestMapping(value = "trang-chu", method = RequestMethod.GET)
	public String Index() {
		return "Home/index";
	}
	@RequestMapping(value = "gioi-thieu", method = RequestMethod.GET)
	public String About() {
		return "Home/about";
	}
}
