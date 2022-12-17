package com.health.example3;

import org.springframework.batch.item.ItemProcessor;

public class PersonProcessor implements ItemProcessor<Person, Person> {
	
	private static final String SPACE = " ";
	public Person process (Person person) throws Exception {
		String[] names = person.getFullName().split(SPACE);
		person.setFirstName(names[0]);
		person.setLastName(names[1]);
		
		return person;
	}

}
