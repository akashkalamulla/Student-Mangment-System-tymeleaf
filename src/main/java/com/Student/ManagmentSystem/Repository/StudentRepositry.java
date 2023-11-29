package com.Student.ManagmentSystem.Repository;

import com.Student.ManagmentSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositry extends JpaRepository<Student,Integer> {
}
