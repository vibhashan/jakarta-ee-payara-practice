package org.vibhashana.jakarta.hello.services;

import org.vibhashana.jakarta.hello.interceptors.Timed;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

// Since this has no-arg constructor, it's a CDI bean. But always better to explicitly mention it.
@ApplicationScoped
public class GreetingService {

	@PostConstruct
	public void init() {

	}

	@Timed
	public String getGreeting(String language) {
		String result;

		switch (language) {
		case "fr": {
			result = "Bonjour! %s";
			break;
		}
		case "de": {
			result = "Willkommen %s";
			break;
		}
		default:
			result = "Hello";
		}

		return result;
	}
}
