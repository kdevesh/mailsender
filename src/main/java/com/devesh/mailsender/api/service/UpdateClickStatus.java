package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.data.CustomerRepository;
import com.devesh.mailsender.api.exception.NotFoundException;
import com.devesh.mailsender.api.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("updateClickStatus")
public class UpdateClickStatus implements MailService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MailService customMailSender;

    @Override
    public void updateClickStatus(UUID uuid) throws NotFoundException {
        Customer customer = customerRepository.findById(uuid).orElse(null);
        if (customer == null)
            throw new NotFoundException("Customer with uuid: " + uuid + " not found");
        else {
            customer.setHasClicked(true);
            SimpleMailMessage simpleMailMessage = createSimpleMailMessage(customer);
            sendMail(simpleMailMessage);
            customerRepository.save(customer);
        }
    }

    private SimpleMailMessage createSimpleMailMessage(Customer customer) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(customer.getEmail());
        message.setSubject("Thank you!!");
        message.setText("Thank you!! " + customer.getFirstName() + " " + "for filling our survey!!");
        return message;
    }

    @Override
    public void sendMail(SimpleMailMessage simpleMailMessage) {
        customMailSender.sendMail(simpleMailMessage);
    }
}
