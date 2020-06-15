package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.exception.NotFoundException;
import org.springframework.mail.SimpleMailMessage;

import java.util.UUID;

public interface MailService {
    void updateClickStatus(UUID uuid) throws NotFoundException;
    void sendMail(SimpleMailMessage simpleMailMessage);
}
