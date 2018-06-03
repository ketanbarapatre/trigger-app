package com.trigger.controllers;

import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public ResponseEntity<String> welcomeMessage() throws SchedulerException {
		return new ResponseEntity<>("Hey, I'm TriggerApp and I can schedule Job for You!", HttpStatus.OK);
	}

}
