package com.sdacademy.httpdemo;

public class InvalidCourseException extends RuntimeException {

    public InvalidCourseException() {
        super();
    }

    public InvalidCourseException(final String message) {
        super(message);
    }

    public InvalidCourseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidCourseException(final Throwable cause) {
        super(cause);
    }
}
