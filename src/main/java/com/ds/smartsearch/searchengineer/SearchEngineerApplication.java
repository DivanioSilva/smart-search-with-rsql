package com.ds.smartsearch.searchengineer;

import com.ds.smartsearch.searchengineer.entities.Person;
import com.ds.smartsearch.searchengineer.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class SearchEngineerApplication implements CommandLineRunner {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

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
		p.setAge(22);
		p.setName("Annina");
		this.personService.save(p);

		List<Person> result = this.personService.findAll();
		result.stream().forEach(System.out::println);

		for (int i = 0; i < 5; i++) {
			Person pp = new Person();
			pp.setName("Arianna");
			pp.setAge(i);
			this.personService.save(pp);
		}

		result = this.personService.findAll();


		List<Person> result2 = this.personService.smartSearch("name==Arianna");

		result2.stream().forEach(System.out::println);
	}
}
