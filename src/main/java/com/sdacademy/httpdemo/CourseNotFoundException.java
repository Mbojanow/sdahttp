package com.sdacademy.httpdemo;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
    }

    public CourseNotFoundException(final String message) {
        super(message);
    }

    public CourseNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CourseNotFoundException(final Throwable cause) {
        super(cause);
    }
}
