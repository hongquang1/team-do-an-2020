package Mlem.com.Common.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Mlem.com.Common.Entity.GeneralCourse;
import Mlem.com.Common.Entity.User;
import Mlem.com.Common.Services.UserService;

@Controller
@Configuration
public class GeneralCourseController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/newGeneralCourse")
	public String NewGeneralCoursePage(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			model.addAttribute("user", null);
		} 
		else {
			User user = userService.getMyUserCookie(userCookie);
			user.setFullName(user.getFullName().replace('+', ' '));
			User user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
			
			model.addAttribute("user", user1);
			GeneralCourse generalCourse = new GeneralCourse();
	        model.addAttribute("generalCourse", generalCourse);
	      
		}
		
		  return "newGeneralCourse";
	}
	
//    @RequestMapping("/newGeneralCourse")
//    public String showNewGeneralCoursePage(Model model) {
//    	GeneralCourse generalsourse = new GeneralCourse();
//        model.addAttribute("generalsourse", generalsourse);
//        return "newGeneralSourse";
//    }
//    @RequestMapping(value = "/saveGeneralSourse", method = RequestMethod.POST)
//    public String saveProduct(@ModelAttribute("generalsourse") GeneralCourse generalCourse) {
//        service.save(product);
//         
//        return "redirect:/";
//    }
}
