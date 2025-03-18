package com.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationScheduler {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendDailyNotification() {
        kafkaProducerService.sendMessage("Reminder: Daily student engagement is important!");
        System.out.println("Sent daily notification to Kafka");
    }
}
