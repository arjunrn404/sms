package com.schoolmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.schoolmanagement.entity.Student;
import com.schoolmanagement.repository.StudentRepository;

import jakarta.persistence.Cacheable;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private KafkaProducerService kafkaProducerService;


    //@Cacheable(value = "students")
    public List<Student> getAllStudents() {
        System.out.println("Fetching from DB...");
        return studentRepository.findAll();
    }

   // @Cacheable(value = "student", key = "#id")
    public Optional<Student> getStudentById(Long id) {
        System.out.println("Fetching from DB...");
        return studentRepository.findById(id);
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public Student saveStudent(Student student) {
    	kafkaProducerService.sendMessage("New student registered: " + student.getName());
        return studentRepository.save(student);
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

