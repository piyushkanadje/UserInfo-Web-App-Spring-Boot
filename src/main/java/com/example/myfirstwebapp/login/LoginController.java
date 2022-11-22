package com.example.myfirstwebapp.login;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RestController;

@Controller
@SessionAttributes("email")
public class LoginController {
      
	private AuthenticationService authenticationService; //authenticationServie is method in AuthenticationServie
	//constructor injection    
	//1- handles @Service bean in Authentication service 
	//2- means we dont have to do  AuthenticationService authenticationService =  new AuthenticationService();
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)

	public String login() {

		return "Login";
	}
 

	
 
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String welcome(@RequestParam String email, String password, ModelMap model) {

		if(authenticationService.authenticate(email, password)) {
			model.put("email", email);
			model.put("password1", password);
			return "welcome";
		}
			
			return "Login" ;
			
		
   
	}

}
