package com.tutorial.fullstacktutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.fullstacktutorial.exception.StudentNotFoundException;
import com.tutorial.fullstacktutorial.model.Student;
import com.tutorial.fullstacktutorial.repo.StudentRepo;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public Student findStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " was not found."));
    }
}
