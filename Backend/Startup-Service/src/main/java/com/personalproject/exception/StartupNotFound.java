package com.personalproject.exception;

public class StartupNotFound extends RuntimeException {
  public StartupNotFound(String message) {
    super(message);
  }
}
