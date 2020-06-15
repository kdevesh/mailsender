package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.data.CustomerRepository;
import com.devesh.mailsender.api.exception.CustomException;
import com.devesh.mailsender.api.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("updateClickStatus")
public class UpdateClickStatus implements MailService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void updateClickStatus(UUID uuid) throws CustomException {
        Customer customer = customerRepository.findById(uuid).orElse(null);
        if(customer==null)
            throw new CustomException("Customer with uuid: "+uuid+" not found");
        else
        {
            customer.setHasClicked(true);
            customerRepository.save(customer);
        }
    }

    @Override
    public void sendMail(SimpleMailMessage simpleMailMessage) {

    }
}
