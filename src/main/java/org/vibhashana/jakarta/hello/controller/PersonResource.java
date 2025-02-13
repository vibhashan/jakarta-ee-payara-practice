package org.vibhashana.jakarta.hello.controller;

import java.util.List;

import org.vibhashana.jakarta.hello.PersonCache;
import org.vibhashana.jakarta.hello.events.AddPersonEvent;
import org.vibhashana.jakarta.hello.models.Person;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/people")
public class PersonResource {
	@Inject
	private PersonCache personCache;

	@Inject
	private Event<AddPersonEvent> addPersonEvent;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPeople() {
		return personCache.getPersons();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(Person person) throws InterruptedException {
		addPersonEvent.fire(new AddPersonEvent(person));
		return Response.created(null).build();
	}
}
