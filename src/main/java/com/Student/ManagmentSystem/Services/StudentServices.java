package com.Student.ManagmentSystem.Services;

import com.Student.ManagmentSystem.Entity.Student;
import com.Student.ManagmentSystem.Repository.StudentRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices implements com.Student.ManagmentSystem.Services.Service {
    private StudentRepositry studentRepositry;

    public StudentServices(StudentRepositry studentRepositry){
        super();
        this.studentRepositry=studentRepositry;
    }
    @Override
    public List<Student> getAllstudent() {
        return studentRepositry.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepositry.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepositry.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepositry.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepositry.deleteById(id);
    }

}
