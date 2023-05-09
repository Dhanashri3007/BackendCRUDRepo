package com.infy.mailtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.infy.mailtask.Model.MailSender;
import com.infy.mailtask.serviceI.MailSenderServiceI;

@RestController
public class MailController {

	@Autowired
	MailSenderServiceI mi;

	@Value("${spring.mail.username}")
	String username;

	@PostMapping("mailSending")
	public String mailSending(@RequestBody MailSender m) {
		System.out.println(username);
		m.setFrom(username);
		try {
			System.out.println("in try 1");
			mi.sendMail(m);

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "Sucessfully Sent";
	}
	
	@PostMapping("mailwithAttachment")
	public String mailSendingWithAttachment(@RequestParam String m,@RequestParam MultipartFile attach) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper js=new ObjectMapper();
		MailSender mobj = js.readValue(m, MailSender.class);
		try {
			mobj.setFrom(username);;
			mi.sendMailwithAttach(mobj,attach);

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "Sucessfully Sent";
	}
	
	
}
