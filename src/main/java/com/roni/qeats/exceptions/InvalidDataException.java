package com.roni.qeats.exceptions;

public class InvalidDataException extends RuntimeException{

  public final String message;

  public InvalidDataException(String message) {
    super(message);
    this.message = message;
  }
}
