package com.ds.smartsearch.searchengineer;

import com.ds.smartsearch.searchengineer.entities.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchEngineerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SearchEngineerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person();
	}
}
