package com.ds.smartsearch.searchengineer;

import com.ds.smartsearch.searchengineer.entities.Car;
import com.ds.smartsearch.searchengineer.entities.Person;
import com.ds.smartsearch.searchengineer.services.CarService;
import com.ds.smartsearch.searchengineer.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SearchEngineerApplication implements CommandLineRunner {

	private final PersonService personService;
	private final CarService carService;

	public SearchEngineerApplication(PersonService personService, CarService carService) {
		this.personService = personService;
		this.carService = carService;
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

		List<Person> result1 = this.personService.findAll();
		result1.stream().forEach(System.out::println);

		for (int i = 0; i < 5; i++) {
			Person pp = new Person();
			pp.setName("Arianna");
			pp.setAge(i);
			this.personService.save(pp);
		}

		//result = this.personService.findAll();


		List<Person> result2 = this.personService.smartSearch("name==Arianna");

		result2.stream().forEach(System.out::println);

		Car car = new Car();
		car.setBrand("VW");
		car.setFuelType("Gasolina");
		car.setNumberOfDoors(5);
		car.setPlate("34-DF-84");

		this.carService.save(car);

		List<Car> carList = this.carService.smartSearch("brand==VW");

		carList.stream().forEach(System.out::println);

	}
}
