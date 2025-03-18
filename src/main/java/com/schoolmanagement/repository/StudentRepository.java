
package com.schoolmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEnrollmentDateBefore(LocalDate date);
}
