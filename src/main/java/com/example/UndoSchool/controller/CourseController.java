package com.example.UndoSchool.controller;


import com.example.UndoSchool.document.CourseDocument;
import com.example.UndoSchool.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseDocument createCourse(@RequestBody CourseDocument course){
        return courseService.saveCourse(course);
    }

    @GetMapping
    public List<CourseDocument> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<CourseDocument> getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
