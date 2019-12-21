package com.ds.smartsearch.searchengineer;

import com.ds.smartsearch.searchengineer.entities.Person;
import com.ds.smartsearch.searchengineer.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchEngineerApplication implements CommandLineRunner {

	private final PersonService personService;

	public SearchEngineerApplication(PersonService personService) {
		this.personService = personService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SearchEngineerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person();
	}
}
