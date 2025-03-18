package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.controller.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {}


