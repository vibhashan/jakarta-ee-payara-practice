package org.vibhashana.jakarta.hello.events;

import org.vibhashana.jakarta.hello.models.Person;

public class AddPersonEvent {
	private Person person;

	public AddPersonEvent(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

}
