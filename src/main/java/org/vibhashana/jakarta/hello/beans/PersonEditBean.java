package org.vibhashana.jakarta.hello.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Data;

@RequestScoped
@Named
@Data
public class PersonEditBean {
	private String name;
	private int age;
}
