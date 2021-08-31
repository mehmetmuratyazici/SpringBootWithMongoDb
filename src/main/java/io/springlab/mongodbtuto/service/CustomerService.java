package io.springlab.mongodbtuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springlab.mongodbtuto.entity.customer.CustomerEntity;
import io.springlab.mongodbtuto.entity.customer.CustomerRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepo;

    public List<CustomerEntity> getSpringLabs(){
        return customerRepo.findAll();
    }

    public CustomerEntity setCustomer(CustomerEntity customerEntity){

        Optional<CustomerEntity> resultCustomer = customerRepo.findCustomerByEmail(customerEntity.getEmail());
      
        if(resultCustomer.isPresent()){

            System.out.println(customerEntity.toString() + " record already exists ! ");
            return null;
        }
        else{
            customerEntity.setCreated(null);
            customerRepo.insert(customerEntity);
            System.out.print(customerEntity.toString() + " record inserted! " );
        }

        return customerEntity;
    }

	public CustomerEntity getCustomer(String email) {

        Optional<CustomerEntity> resultQuery = customerRepo.findCustomerByEmail(email);

		return resultQuery.isPresent() ? resultQuery.get() : null;
	}




}
