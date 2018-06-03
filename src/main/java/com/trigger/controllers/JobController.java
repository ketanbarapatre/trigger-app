package com.trigger.controllers;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trigger.main.MailJob;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.JobBuilder.*;

@RestController
public class JobController {

	@Autowired	
	private Scheduler scheduler;

	@GetMapping("/")
	public ResponseEntity<String> welcomeMessage() throws SchedulerException {
		JobDetail job = newJob(MailJob.class).withIdentity("jobName", "groupName").build();
		// Create Trigger
		Trigger trigger = newTrigger().withIdentity("triggerName", "groupName").startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();
		scheduler.scheduleJob(job, trigger);

		return new ResponseEntity<>("Hey, I'm TriggerApp and I can schedule Job for You!", HttpStatus.OK);
	}

}
