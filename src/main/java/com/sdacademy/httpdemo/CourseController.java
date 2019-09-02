package com.sdacademy.httpdemo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseRepository courseRepository;

    public CourseController(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable final String id) {
        return courseRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSource(@RequestBody final Course course) {
        courseRepository.add(course);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSource(@PathVariable final String id, @RequestBody final Course course) {
        courseRepository.update(id, course);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePartiallySource(@PathVariable final String id, @RequestBody final Course course) {
        courseRepository.partialUpdate(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePartiallySource(@PathVariable final String id) {
        courseRepository.delete(id);
    }
}
