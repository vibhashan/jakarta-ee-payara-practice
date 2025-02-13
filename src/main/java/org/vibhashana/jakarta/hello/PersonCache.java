package org.vibhashana.jakarta.hello;

import java.util.ArrayList;
import java.util.List;

import org.vibhashana.jakarta.hello.events.AddPersonEvent;
import org.vibhashana.jakarta.hello.models.Person;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class PersonCache {
	private List<Person> persons = new ArrayList<>();

	// Observes for an Event of type AddPersonEvent
	public void addPerson(@Observes AddPersonEvent addPersonEvent) {
		this.persons.add(addPersonEvent.getPerson());
	}

	public List<Person> getPersons() {
		return persons;
	}
}