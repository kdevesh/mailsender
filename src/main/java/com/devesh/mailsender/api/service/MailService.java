package com.devesh.mailsender.api.service;

import com.devesh.mailsender.api.exception.CustomException;
import org.springframework.mail.SimpleMailMessage;

import java.util.UUID;

public interface MailService {
    void updateClickStatus(UUID uuid) throws CustomException;
    void sendMail(SimpleMailMessage simpleMailMessage);
}
