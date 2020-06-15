package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("customMailSender")
public class CustomMailSender implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void updateClickStatus(UUID uuid) throws NotFoundException {

    }

    @Async
    @Override
    public void sendMail(SimpleMailMessage simpleMailMessage) {
        mailSender.send(simpleMailMessage);
    }
}
