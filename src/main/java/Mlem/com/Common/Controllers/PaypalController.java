package Mlem.com.Common.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import Mlem.com.Common.Entity.GeneralCourse;
import Mlem.com.Common.Entity.Order;
import Mlem.com.Common.Entity.PayMent;
import Mlem.com.Common.Entity.User;
import Mlem.com.Common.Repository.UserRepository;
import Mlem.com.Common.Services.GeneralCourseService;
import Mlem.com.Common.Services.PaymentService;
import Mlem.com.Common.Services.PaypalService;
import Mlem.com.Common.Services.UserService;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;
	@Autowired
	PaymentService payS;
	@Autowired
	GeneralCourseService gS;
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";


	@Autowired
	UserService userService;

	@RequestMapping(value = "/paypal", method = RequestMethod.POST)
	public String Home(int id,
			Model model) {
			GeneralCourse genC = gS.findGeneralCourseById(id);
			model.addAttribute("genC", genC);
	 return "paypal";
	}

	@RequestMapping(value = "/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {

			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
				Model model) {
	        try {
	        	if(userCookie.equals("defaultCookieValue")) {
	    			
	    			
	    			model.addAttribute("user", null);
	    		} 
	    		else {
	    		  	User user = userService.getMyUserCookie(userCookie);
	    			User user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
	    			user.setFullName(user.getFullName().replace('+', ' '));
	    			model.addAttribute("user", user1);
	    			PayMent payment1 = new PayMent();
	    	        model.addAttribute("payment", payment1);
	    			 Payment payment = service.executePayment(paymentId, payerId);
	 	            System.out.println(payment.toJSON());
	 	            if (payment.getState().equals("approved")) {
	 	            	Transaction transaction = payment.getTransactions().get(0);
	 	            	int courseID = Integer.parseInt(transaction.getDescription());
	 	            	payment1.setAccountId(user1.getId());
	 	            	payment1.setGeneralCourseId(courseID);
	 	            	payS.save(payment1);
	 	            	
	 	            	System.out.println("Test*******"+transaction.getDescription());
	 	                return "success";
	    		}
	           
	            }
	        } catch (PayPalRESTException e) {
	         e.printStackTrace();
	        }
	        return "redirect:/";
	    }
	    
	 }
