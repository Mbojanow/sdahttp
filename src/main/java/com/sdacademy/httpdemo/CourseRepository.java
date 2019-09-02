package com.sdacademy.httpdemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CourseRepository {

    private List<Course> courses = new ArrayList<>();
    public CourseRepository() {
        courses.add(Course.builder()
                .id("1")
                .name("Java")
                .description("Junior Java Developer Course")
                .price(1000L)
                .build());
        courses.add(Course.builder()
                .id("2")
                .name("Tester")
                .description("Manual Tester Course preparing for ISTQB")
                .price(500L)
                .build());
    }


    public void add(final Course course) {
        if (courseByNameExists(course)) {
            throw new InvalidCourseException("Course with duplicated name found");
        }
        course.setId(String.valueOf(courses.size() + 1));
        courses.add(course);
    }

    public void delete(final String id) {
        courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst().ifPresent(c -> courses.remove(c));
    }

    public void update(final String id, final Course course) {
        if (courses.stream().noneMatch(c -> c.getId().equals(id))) {
            throw new InvalidCourseException("Course with given id does not exist");
        }

        if ((course.getName() == null || course.getName().length() == 0) ||
                (course.getPrice() == null || course.getPrice() <= 0.0) ||
                course.getDescription() == null || course.getDescription().length() == 0) {
            throw new InvalidCourseException("Cannot update because input object is invalid");
        }

        for (final Course c : courses) {
            if (c.getId().equals(id)) {
                c.setDescription(course.getDescription());
                c.setName(course.getName());
                c.setPrice(course.getPrice());
            }
        }
    }

    public void partialUpdate(final String id, final Course course) {
        if (courses.stream().noneMatch(c -> c.getId().equals(id))) {
            throw new InvalidCourseException("Course with given id does not exist");
        }

        for (final Course c : courses) {
            if (c.getId().equals(id)) {
                if (course.getDescription() != null && course.getDescription().length() > 0) {
                    c.setDescription(course.getDescription());
                }

                if (course.getName() != null && course.getName().length() != 0) {
                    c.setName(course.getName());
                }

                if (course.getPrice() != null && course.getPrice() >= 0.0) {
                    c.setPrice(course.getPrice());
                }
            }
        }
    }

    public Course getById(final String id) {
        final Optional<Course> first = courses.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (!first.isPresent()) {
            throw new CourseNotFoundException("Course with given id not found");
        }

        return first.get();
    }

    private boolean courseByNameExists(final Course course) {
        return courses.stream().map(Course::getName).collect(Collectors.toList()).contains(course.getName());
    }

    public List<Course> getCourses() {
        return courses;
    }
}
