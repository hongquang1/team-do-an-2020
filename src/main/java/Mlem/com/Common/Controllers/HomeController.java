package Mlem.com.Common.Controllers;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Mlem.com.Common.Entity.User;
import Mlem.com.Common.Repository.UserRepository;
import Mlem.com.Common.Services.UserService;


 

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository repo;
	@RequestMapping("/")
	public String Home(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			User user = userService.getMyUserCookie(userCookie);
			User user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
			user.setFullName(user.getFullName().replace('+', ' '));
			model.addAttribute("user", user1);
		}
		
	 return "index";
	}
	@RequestMapping("listcourse")
	public String Listcourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			User user = userService.getMyUserCookie(userCookie);
			User user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
			user.setFullName(user.getFullName().replace('+', ' '));
			model.addAttribute("user", user1);
		}
			
		return "listcourse";
	}
	@RequestMapping("levelcourse")
	public String Levelcourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			User user = userService.getMyUserCookie(userCookie);
			User user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
			user.setFullName(user.getFullName().replace('+', ' '));
			model.addAttribute("user", user1);
		}
			
		return "levelcourse";
	}
	@RequestMapping("course_detail_view")
	public String Course_detail_view(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			User user = userService.getMyUserCookie(userCookie);
			User user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
			user.setFullName(user.getFullName().replace('+', ' '));
			model.addAttribute("user", user1);
		}
			
		return "course_detail_view";
	}
	@RequestMapping(value = "/res", method  = RequestMethod.POST)
	public String ACC() {
		return "home";
		
	}
	@RequestMapping(value = "/fragments", method  = RequestMethod.GET)
	public String a() {
		return "fragments";
		
	}
}
