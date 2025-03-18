package com.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schoolmanagement.repository.StudentRepository;
@Service
public class ScheduledTasks {

    @Autowired
    private StudentRepository studentRepository;

    @Scheduled(cron = "0 0 10 * * ?")  //10 AM
    public void reportStudentCount() {
        long count = studentRepository.count();
        System.out.println("Total Students as of now: " + count);
    }

}
