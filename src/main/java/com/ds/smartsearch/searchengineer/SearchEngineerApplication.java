package com.ds.smartsearch.searchengineer;

import com.ds.smartsearch.searchengineer.entities.*;
import com.ds.smartsearch.searchengineer.repositories.querydsl.CarQueryDSLRepository;
import com.ds.smartsearch.searchengineer.repositories.querydsl.CityQueryDSLRepository;
import com.ds.smartsearch.searchengineer.repositories.querydsl.PersonQueryDSLRepository;
import com.ds.smartsearch.searchengineer.services.CarQueryDSLService;
import com.ds.smartsearch.searchengineer.services.CarService;
import com.ds.smartsearch.searchengineer.services.PersonService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchEngineerApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SearchEngineerApplication.class);

	private final PersonService personService;
	private final CarService carService;
	private final CityQueryDSLRepository cityQueryDSLRepository;
	private final CarQueryDSLRepository carQueryDSLRepository;
	private final PersonQueryDSLRepository personQueryDSLRepository;

	private final CarQueryDSLService carQueryDSLService;

	public SearchEngineerApplication(PersonService personService,
									 CarService carService,
									 CityQueryDSLRepository cityQueryDSLRepository,
									 CarQueryDSLRepository carQueryDSLRepository,
									 PersonQueryDSLRepository personQueryDSLRepository,
									 CarQueryDSLService carQueryDSLService) {
		this.personService = personService;
		this.carService = carService;
		this.cityQueryDSLRepository = cityQueryDSLRepository;
		this.carQueryDSLRepository = carQueryDSLRepository;
		this.personQueryDSLRepository = personQueryDSLRepository;
		this.carQueryDSLService = carQueryDSLService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SearchEngineerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//RSQL a funcionar
		/**
		Person p = new Person();
		p.setAge(22);
		p.setName("Annina");
		this.personService.save(p);

		List<Person> result1 = this.personService.findAll();
		result1.stream().forEach(System.out::println);

		for (int i = 0; i < 1; i++) {
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
		car.setBuildYear(2000);
		car.setPlateYear(2001);
		this.carService.save(car);

		car = new Car();
		car.setBrand("VW");
		car.setFuelType("Gasóleo");
		car.setNumberOfDoors(3);
		car.setPlate("34-DF-00");
		car.setBuildYear(2010);
		car.setPlateYear(2011);

		this.carService.save(car);

		List<Car> carList = this.carService.smartSearch("brand==VW");

		List<Car> carList2 = this.carService.smartSearch("brand==VW; plateYear>=2000");

		List<Car> carList3 = this.carService.smartSearch("brand==VW; buildYear==2000; plateYear==2001");

		carList.stream().forEach(System.out::println);

		p.setCars(carList);

		Person pp = personService.save(p);

		List<Person> notLikeQuery = this.personService.smartSearch("name!=*nina");
		List<Person> likeQuery = this.personService.smartSearch("name==*nina");
		//List<Person> likeAndJoinQuery = this.personService.smartSearch("name==*nina; cars.brand==VW");
		System.out.println();

		/**
		JPAQuery query = new JPAQuery(entityManager);

		QCity qCity = QCity.city;
		QueryBase cities =  query.from(qCity)
				.where(qCity.name.eq("Bratislava"));

		JPAQuery query1 = new JPAQuery(entityManager);

		query1.from(qCity).where(qCity.name.eq("Bratislava")).distinct();


		City c1 = (City) query.fetch();

		logger.info("{}", c1);
*/

		QCity qCity = QCity.city;

		Predicate pred = qCity.name.contains("Bratislava");
		Predicate pred1 = qCity.population.goe(200);

		BooleanExpression booleanExpression = qCity.population.goe(200).and(qCity.name.contains("tis"));
		OrderSpecifier<String> orderSpecifier = qCity.name.asc();
		Iterable<City> cities2 = cityQueryDSLRepository.findAll(booleanExpression, orderSpecifier);
		logger.info("{}", cities2);

		QCity qCityy = QCity.city;
		Predicate predicate = qCityy.id.eq(1L);
		Iterable<City> cities3 = cityQueryDSLRepository.findAll(predicate);
		logger.info("{}", cities3);

		QCar qCar = QCar.car;
		Predicate carPredicate = qCar.brand.eq("VW");
		Iterable<Car> cars = carQueryDSLRepository.findAll(carPredicate);
		logger.info("{}", cars);

		QCar qCarV2 = QCar.car;
		Predicate carPredicateV2 = qCarV2.person.name.eq("Marianna");
		Iterable<Car> carsV2 = carQueryDSLRepository.findAll(carPredicateV2);
		logger.info("{}", cars);

		QPerson qPerson = QPerson.person;
		Predicate personPredicate = qPerson.name.eq("Marianna").and(qPerson.cars.isNotEmpty());
		Iterable<Person> persons = personQueryDSLRepository.findAll(personPredicate);
		logger.info("{}", persons);

		Iterable<Car> carsIt = carQueryDSLService.findCarSmartSearch("VW", "Gasolina", "", null, null, 2001);

		logger.info("{}", carsIt);

		/**
		QueryBase query2 = new JPAQuery(entityManager);
		query2.from(qCity).where(qCity.name.endsWith("est").and(qCity.population.lt(1800000)));
		var cities = query2.fetch();

		logger.info("{}", cities);

		BooleanExpression booleanExpression = qCity.population.goe(2_000_000);
		OrderSpecifier<String> orderSpecifier = qCity.name.asc();
		var cities2 = cityRepository.findAll(booleanExpression, orderSpecifier);

		logger.info("{}", cities2);
*/


	}
}
