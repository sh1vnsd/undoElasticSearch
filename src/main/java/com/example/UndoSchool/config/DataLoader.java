package com.example.UndoSchool.config;

import com.example.UndoSchool.document.CourseDocument;
import com.example.UndoSchool.repository.CourseRepo;
import com.example.UndoSchool.service.CourseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void run(String... args) throws Exception {
        if(courseRepo.count() == 0) {
            try (InputStream is = getClass().getResourceAsStream("/sample-courses.json")) {
                List<CourseDocument> courses = objectMapper.readValue(
                        is,
                        new TypeReference<List<CourseDocument>>(){}
                );

                courseRepo.saveAll(courses);
                System.out.println("Indexed sample courses" + courses.size());
            }
        }
        else{
            System.out.println("Courses already indexed");
        }
    }
}
