package com.example.raj.cool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PahlaprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(PahlaprojectApplication.class, args);
		Car car1 = context.getBean(Car.class);
		System.out.println(car1);
		
		Car car2 = context.getBean(Car.class);
		System.out.println(car2);
		
		Car car3 = context.getBean(Car.class);
		System.out.println(car3.getEngine().getCc());
		
//		car car1 = new car();
//		Engine engine1 = new Engine ();
//		car1.setEngine(engine1);
//		
		
	}

}
