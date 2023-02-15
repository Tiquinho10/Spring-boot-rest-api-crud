package com.tique.dev.rest.model;

import com.tique.dev.rest.repository.StudentRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class StudentGenerator implements ApplicationRunner {

     private final StudentRepository studentRepository;

    public StudentGenerator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (studentRepository.Count() != 0)
                     return;

        Student s1 =   new Student(
                "Luiz",
                "luiz@gmail.com",
                LocalDate.of(1990, Month.NOVEMBER, 23)
        );

        Student s2 =  new Student(
                "bernado",
                "bernado@gmail.com",
                LocalDate.of(2000, Month.SEPTEMBER, 3));


        studentRepository.saveAll(
                List.of(s1, s2)
        );
    }
}
