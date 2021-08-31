package io.springlab.mongodbtuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import io.springlab.mongodbtuto.entity.customer.CustomerRepository;
import io.springlab.mongodbtuto.entity.customer.CustomerEntity;

import io.springlab.mongodbtuto.enums.Gender;
import io.springlab.mongodbtuto.entity.customer.Address;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodbTutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbTutoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepo, MongoTemplate mongoTemplate){
			return args -> {
				Address address = new Address(
					"Turkey",
					"Trabzon",
					"61100"
				);
				CustomerEntity customerEntity = new CustomerEntity(
					"Mehmet Murat",
					"YAZICI",
					"mhmtmrtyzc@gmail.com",
					Gender.MALE,
					address,
					LocalDate.of(1989, 9, 21)
				);

				Optional<CustomerEntity> resultOpt = customerRepo.findCustomerByEmail(customerEntity.getEmail());
				resultOpt.ifPresentOrElse(r -> System.out.println(r.toString() + " already exists"),
				()-> {
					System.out.println(" Inserting customer " + customerEntity );
					customerRepo.insert(customerEntity);
				});


				//mongoTemplateAndQuery(customerEntity, mongoTemplate, customerRepo);
				

			};
	}


	private void mongoTemplateAndQuery(CustomerEntity customerEntity, MongoTemplate mongoTemplate, CustomerRepository customerRepo){
			    Query query = new Query();

				query.addCriteria(Criteria.where("email").is(customerEntity.getEmail()));

				List<CustomerEntity> customers = mongoTemplate.find(query, CustomerEntity.class);
				if(customers.size() > 1){
					throw new IllegalStateException(" found many customer with email " + customerEntity.getEmail());
				}

				if(customers.isEmpty()){
					System.out.println(" Inserting customer " + customerEntity );
					customerRepo.insert(customerEntity);

				}
				else {
					System.out.println( customerEntity.toString() + " already exists");
				}

				
	}

}
