package com.schoolmanagement.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.repository.StudentRepository;

@Service
public class CleanupScheduler {

    @Autowired
    private StudentRepository studentRepository;

    @Scheduled(cron = "0 0 0 * * SUN")
    public void cleanupInactiveStudents() {
        List<Student> inactiveStudents = studentRepository.findByEnrollmentDateBefore(LocalDate.now().minusYears(5));
        studentRepository.deleteAll(inactiveStudents);
        System.out.println("Cleaned up inactive students");
    }
}

