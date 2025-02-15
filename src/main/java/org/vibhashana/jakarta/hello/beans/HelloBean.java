package org.vibhashana.jakarta.hello.beans;

import org.vibhashana.jakarta.hello.services.GreetingService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

@RequestScoped
@Named // If name not explicitly specified the camel case version of the class name is
		// used.
@Data
public class HelloBean {
	private String name;
	private String greeting;
	private final GreetingService greetingService;

	@Inject
	public HelloBean(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public void greet() {
		greeting = String.format(greetingService.getGreeting("fg"), name);
	}
}
