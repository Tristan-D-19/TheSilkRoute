package com.aws.codestar.silkroute.service;

public interface SecurityService {
	
	  String findLoggedInUsername();

	 void autologin(String username, String password);

}
