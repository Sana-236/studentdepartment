package com.example.Student.controller;

import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String showDepartmentPage(){
        return "department";
    }

    @PostMapping("/students")
    public String process(Model model, @RequestParam String department) {
        List<Student> branchStudents = studentService.getStudentsByBranch(department);
        model.addAttribute("students", branchStudents);
        return "department";
    }
}