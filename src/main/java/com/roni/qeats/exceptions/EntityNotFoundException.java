package com.roni.qeats.exceptions;

public class EntityNotFoundException extends RuntimeException{

  public final String message;

  public EntityNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
