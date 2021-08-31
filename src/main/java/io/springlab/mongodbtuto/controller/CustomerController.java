package io.springlab.mongodbtuto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.springlab.mongodbtuto.entity.customer.CustomerEntity;
import io.springlab.mongodbtuto.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    private ResponseEntity<?> getSpringLab(){
        return ResponseEntity.ok("Say hello \"Customer Controller\"");
    }

    @GetMapping(path = "/getCustomerAll")
    private ResponseEntity<?> getSpringLabAll(){
        return ResponseEntity.ok(customerService.getSpringLabs());
    }

    @PostMapping(path = "/setCustomer")
    private ResponseEntity<?> setCustomer(@RequestBody CustomerEntity customerEntity){

        return ResponseEntity.ok( customerService.setCustomer(customerEntity));

    }

    @GetMapping("/getCustomer")
    private ResponseEntity<?> getCustomer(
        @RequestParam String email
        ){
        
        return ResponseEntity.ok(customerService.getCustomer(email));
    }

}
