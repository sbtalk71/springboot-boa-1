package com.demo.spring;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Performer performer = (Performer) ctx.getBean("singer");
		//Singer performer=(Singer)ctx.getBean("singer");

		System.out.println(performer.getClass().getName());
		
		for (Method m : performer.getClass().getMethods()) {
			System.out.println(m.getName());
		}

		performer.perform("John", 25);

	}

}
