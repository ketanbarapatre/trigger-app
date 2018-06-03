package com.trigger.config;

import java.io.FileNotFoundException;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class SchedulerConfig {

	@Bean
	public SchedulerFactoryBean schedulerFactory(ApplicationContext applicationContext, DataSource dataSource,
			Executor taskExecutor) throws FileNotFoundException {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setDataSource(dataSource);
		schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
		schedulerFactoryBean.setTaskExecutor(taskExecutor);
		schedulerFactoryBean.setJobFactory(springBeanJobFactory(applicationContext));
		schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
		return schedulerFactoryBean;
	}

	private SpringBeanJobFactory springBeanJobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

}
