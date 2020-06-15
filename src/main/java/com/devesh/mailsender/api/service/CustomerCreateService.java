package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.data.CustomerRepository;
import com.devesh.mailsender.api.exception.NotFoundException;
import com.devesh.mailsender.api.exception.SaveException;
import com.devesh.mailsender.api.model.Customer;
import com.devesh.mailsender.api.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreateService {
    @Autowired
    CustomerRepository customerRepository;
    public void createCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setHasClicked(false);
        try {
            customerRepository.save(customer);
        }catch (Exception e){
            throw new SaveException("Customer couldn't be created: "+e.getMessage());
        }
    }
}
