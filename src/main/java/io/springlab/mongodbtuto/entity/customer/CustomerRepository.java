package io.springlab.mongodbtuto.entity.customer;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  
        extends MongoRepository<CustomerEntity, String>  {
    
    Optional<CustomerEntity> findCustomerById(String id);
    Optional<CustomerEntity> findCustomerByEmail(String email);
}
