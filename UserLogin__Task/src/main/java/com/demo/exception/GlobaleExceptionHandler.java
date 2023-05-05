package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.model.UserLogin;

@RestControllerAdvice
public class GlobaleExceptionHandler {

	@ExceptionHandler(UserNameNotValide.class)
	public ResponseEntity<String> userNameValidation()
	{
		return new ResponseEntity<String>("You Enter Invalide UserName", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(InvalidePassword.class)
	public ResponseEntity<String> invalidePassword()
	{
		return new ResponseEntity<String>("You Enter Invalide Password", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Invalide__FistName__LastName.class)
	public ResponseEntity<String> invalideFirstNameLastName()
	{
		return new ResponseEntity<String>("You Enter Invalide Name", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Invalide__EmailAddress.class)
	public ResponseEntity<String> invalideEmail()
	{
		return new ResponseEntity<String>("You Enter Invalide EmailAdress", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Invalide__Contact.class)
	public ResponseEntity<String> invalideContact()
	{
		return new ResponseEntity<String>("You Enter Invalide Contact Number", HttpStatus.NOT_ACCEPTABLE);
	}
}
