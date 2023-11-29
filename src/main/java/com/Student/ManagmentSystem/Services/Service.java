package com.Student.ManagmentSystem.Services;

import com.Student.ManagmentSystem.Entity.Student;

import java.util.List;

public interface Service {
    List<Student> getAllstudent();
    Student saveStudent(Student student);
    Student getStudentById(Integer id);
    Student updateStudent(Student student);
    void deleteStudentById(Integer id);
}
