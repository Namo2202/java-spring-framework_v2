package com.in28minutes.learn_spring_framework.exercices_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BusinessCalculationLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(BusinessCalculationLauncherApplication.class)) {
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
