package br.com.danielcrdev.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.danielcrdev.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {

	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Daniel");
		person.setLastName("Ribeiro");
		person.setAddress("Av. Omega 174");
		person.setGender("M");
		return person;
	}
	
	public List<Person>	findAll(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nome " + i);
		person.setLastName("Sobrenome " + i);
		person.setAddress("Endereço" + i + " no Brasil");
		person.setGender("M" + i);
		return person;
	}

}
