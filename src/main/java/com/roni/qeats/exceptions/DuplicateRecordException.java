package com.roni.qeats.exceptions;

public class DuplicateRecordException extends RuntimeException{

  public final String message;

  public DuplicateRecordException(String message) {
    super(message);
    this.message = message;
  }
}
