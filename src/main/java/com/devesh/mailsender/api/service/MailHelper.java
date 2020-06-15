package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.data.CustomerRepository;
import com.devesh.mailsender.api.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MailHelper {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MailService customMailSender;

    public void sendMail() {
        List<Customer> customerList = customerRepository.findByhasClicked(false);
        sendMail(customerList);
    }

    private void sendMail(List<Customer> customerList) {
        for (Customer customer : customerList) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(customer.getEmail());
            message.setSubject("Activation Link");
            message.setText("To confirm your e-mail address, please click the link below:\n" + "http://localhost:8080/validate?uuid=" + customer.getId());
            customMailSender.sendMail(message);
        }
    }
}
