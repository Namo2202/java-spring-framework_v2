package com.in28minutes.learn_spring_framework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	
	private SomeDependancy someDependancy;

	public SomeClass(SomeDependancy someDependancy) {
		super();
		this.someDependancy = someDependancy;
		System.out.println("All dependencies are ready");
	}
	
	@PostConstruct
	public void initialize() {
		someDependancy.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Cleanup");
	}
}

@Component
class SomeDependancy {
	public void getReady() {
		System.out.println("Some logic");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
//			context.getBean(GamingConsole.class).up();
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}

}
