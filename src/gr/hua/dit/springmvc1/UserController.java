package gr.hua.dit.springmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")

public class UserController {

	@RequestMapping("/")
	public String showMyPage() {
		   return "index";
		}
}
