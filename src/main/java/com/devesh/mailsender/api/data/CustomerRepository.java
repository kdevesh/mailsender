package com.devesh.mailsender.api.data;

import com.devesh.mailsender.api.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    List<Customer> findByhasClicked(boolean hasClicked);
}
