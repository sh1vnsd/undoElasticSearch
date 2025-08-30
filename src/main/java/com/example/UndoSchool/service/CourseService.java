package com.example.UndoSchool.service;

import com.example.UndoSchool.document.CourseDocument;
import com.example.UndoSchool.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public CourseDocument saveCourse(CourseDocument course) {
        return courseRepo.save(course);
    }

    public List<CourseDocument> getAllCourses() {
        Iterable<CourseDocument> iterable = courseRepo.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<CourseDocument> getCourseById(String id) {
        return courseRepo.findById(id);
    }

    public void deleteCourse(String id) {
        courseRepo.deleteById(id);
    }
}
