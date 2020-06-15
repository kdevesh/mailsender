package com.devesh.mailsender.api.controller;

import com.devesh.mailsender.api.exception.CustomException;
import com.devesh.mailsender.api.service.MailHelper;
import com.devesh.mailsender.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MailController {
    @Autowired
    MailService updateClickStatus;
    @Autowired
    MailHelper mailHelper;

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestParam("uuid") UUID uuid) throws CustomException {
        updateClickStatus.updateClickStatus(uuid);
        return ResponseEntity.status(HttpStatus.OK).body("Active");
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMail() {
        mailHelper.sendMail();
        return ResponseEntity.status(HttpStatus.OK).body("Mail Sent");
    }
}
