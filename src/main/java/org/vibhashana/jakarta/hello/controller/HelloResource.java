package org.vibhashana.jakarta.hello.controller;

import org.vibhashana.jakarta.hello.services.GreetingService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
	private GreetingService greetingService;

	@Inject
	public HelloResource(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello World";
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String doGreeting(@PathParam("name") String name, @QueryParam("language") String language) {
		return String.format(greetingService.getGreeting(language), name);
	}
}
