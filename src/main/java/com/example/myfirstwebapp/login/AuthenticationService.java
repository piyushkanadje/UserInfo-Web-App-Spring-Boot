package com.example.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service   //make as bean because its business logic
public class AuthenticationService {
  


public boolean authenticateService(String email, String password) {
	 
	
boolean isValidemail =email.equalsIgnoreCase("admin@admin.com");
boolean isValidpassword = password.equalsIgnoreCase("admin@123");

	return isValidemail && isValidpassword;
}
	 
}
