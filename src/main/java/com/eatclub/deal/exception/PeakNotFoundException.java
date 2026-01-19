package com.eatclub.deal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PeakNotFoundException extends RuntimeException {

  public PeakNotFoundException(String message) {
    super(message);
  }
}

