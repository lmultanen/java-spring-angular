package com.tutorial.fullstacktutorial.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.fullstacktutorial.model.Student;

// JpaRepository needs the model name and type of primary key, for personal note
public interface StudentRepo extends JpaRepository<Student, Long> {
}
