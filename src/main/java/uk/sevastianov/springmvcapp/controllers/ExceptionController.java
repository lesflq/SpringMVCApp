package uk.sevastianov.springmvcapp.controllers;

import jakarta.servlet.ServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public Object hand(ServletRequest request, Exception e) {
        System.out.println(e.getMessage());
        return "error";
    }
}
