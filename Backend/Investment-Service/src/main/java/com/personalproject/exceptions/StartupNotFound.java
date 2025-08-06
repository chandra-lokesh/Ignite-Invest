package com.personalproject.exceptions;

public class StartupNotFound extends RuntimeException {
  public StartupNotFound(String message) {
    super(message);
  }
}
