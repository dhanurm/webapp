package com.clc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExample {
	static {
		System.out.println("In ASpect Class.................................");
	}

	@Before("execution(* *  com.clc.service.EmployeeServiceImpl.getAllEmps() )")
	public void beforAdd() {
		System.out.println("Befor add Method---------------------------------------------");
	}
}
