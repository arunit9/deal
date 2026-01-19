package com.eatclub.deal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidInputException.class)
  @ResponseBody
  public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex) {

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}

