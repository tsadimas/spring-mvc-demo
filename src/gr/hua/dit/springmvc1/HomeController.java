package gr.hua.dit.springmvc1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/showForm")
	public String showForm() {
	        return "helloworld-form";
	}
	@RequestMapping("/processForm")
	public String processForm() {
	        return "helloworld";
	}
	@RequestMapping("/processFormv2")
	public String processFormv2(HttpServletRequest request, Model model) {
	   String theName = request.getParameter("studentName");
	   theName = theName.toUpperCase();
	   String result ="Hello " + theName;
	   model.addAttribute("message",result);
	   return "helloworld";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
