package com.devesh.mailsender.api.tasks;

import com.devesh.mailsender.api.service.MailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Autowired
    MailHelper mailHelper;

    @Scheduled(cron = "*/5 * * * * *")
    public void sendMail() {
        mailHelper.sendMail();
    }
}
