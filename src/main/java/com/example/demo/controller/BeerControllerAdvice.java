package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BeerControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<String>> constraintViolationErrorHandler(
      MethodArgumentNotValidException e) {
    return ResponseEntity.badRequest()
        .body(
            e.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                .collect(Collectors.toList()));
  }
}
