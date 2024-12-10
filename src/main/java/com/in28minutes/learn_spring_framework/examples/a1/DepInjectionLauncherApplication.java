package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass{
	
	Dependancy1 dependancy1;
	
	Dependancy2 dependancy2;
	
//	@Autowired
	public YourBusinessClass(Dependancy1 dependancy1, Dependancy2 dependancy2) {
		super();
		System.out.println("Constructor injection - YourBusinessClass");
		this.dependancy1 = dependancy1;
		this.dependancy2 = dependancy2;
	}

//	@Autowired
//	public void setDependancy1(Dependancy1 dependancy1) {
//		System.out.println("Setter injection - setDependancy1");
//		this.dependancy1 = dependancy1;
//	}
//
//	@Autowired
//	public void setDependancy2(Dependancy2 dependancy2) {
//		System.out.println("Setter injection - setDependancy2");
//		this.dependancy2 = dependancy2;
//	}

	public String toString() {
		return "using: "+dependancy1+" and "+dependancy2;
	}
}

@Component
class Dependancy1 {
	
}

@Component
class Dependancy2 {
	
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
			System.out.println(context.getBean(YourBusinessClass.class));
		}
	}

}
