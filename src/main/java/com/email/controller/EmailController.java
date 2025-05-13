package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Hello this .is email api";
	}
	
	//api to send email
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		boolean result = this.emailService.sendEmail(request.getMessage(), request.getSubject(), request.getTo());
		System.out.println(request);
		if(result)
		{
			return ResponseEntity.ok("Mail sent Successfully");
		}
		else {
			return ResponseEntity.badRequest().body("email not sent");
		}
		
	}
}
