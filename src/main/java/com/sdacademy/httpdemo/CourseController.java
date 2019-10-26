package com.sdacademy.httpdemo;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
    public ResponseEntity<Object> saveSource(@RequestBody final Course course) {
        courseRepository.add(course);

        final Course insertedCourse = courseRepository.getCourses().stream()
                .max(Comparator.comparing(Course::getId)).get();

        return ResponseEntity.noContent()
                .header(HttpHeaders.LOCATION, "/api/courses/" + insertedCourse.getId())
                .build();
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
