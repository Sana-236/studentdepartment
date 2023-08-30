package com.example.Student.service;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByBranch(String branch) {
        List<Student> allStudents=studentRepository.findAll();

        List<Student> branchedStudents = new ArrayList<>();

        for(Student iteration:allStudents){
            if (iteration.getBranch().equalsIgnoreCase(branch)) {
                branchedStudents.add(iteration);
            }
        }
        return branchedStudents;
    }
}
