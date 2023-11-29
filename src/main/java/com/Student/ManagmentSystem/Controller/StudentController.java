package com.Student.ManagmentSystem.Controller;

import com.Student.ManagmentSystem.Entity.Student;
import com.Student.ManagmentSystem.Services.StudentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentServices studentServices;
    public StudentController(StudentServices studentServices){
        super();
        this.studentServices=studentServices;
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentServices.getAllstudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForum(Model model){
        Student student=new Student();
        model.addAttribute("students",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudents(@ModelAttribute("students")Student student){
        studentServices.saveStudent(student);
        return "redirect:/students";
    }


    @PostMapping("/students/edit/{id}")
        public String updateStudent(@PathVariable Integer id,@ModelAttribute("student") Student student,Model model) {

        Student existingStudent = studentServices.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentServices.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudents(@PathVariable Integer id){
        studentServices.deleteStudentById(id);
        return "redirect:/students";
    }

}
