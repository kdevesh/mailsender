package com.devesh.mailsender.api.controller;

import com.devesh.mailsender.api.exception.NotFoundException;
import com.devesh.mailsender.api.model.CustomerDto;
import com.devesh.mailsender.api.service.CustomerCreateService;
import com.devesh.mailsender.api.service.MailHelper;
import com.devesh.mailsender.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class MailController {
    @Autowired
    MailService updateClickStatus;
    @Autowired
    MailHelper mailHelper;
    @Autowired
    CustomerCreateService customerCreateService;

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam("uuid") UUID uuid) throws NotFoundException {
        updateClickStatus.updateClickStatus(uuid);
        return ResponseEntity.status(HttpStatus.OK).body("Active");
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMail() {
        mailHelper.sendMail();
        return ResponseEntity.status(HttpStatus.OK).body("Mail Sent");
    }
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto){
        customerCreateService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.OK).body("Customer created");
    }
}
