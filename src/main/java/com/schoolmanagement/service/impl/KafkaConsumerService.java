package com.schoolmanagement.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "student_topic", groupId = "school-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}

