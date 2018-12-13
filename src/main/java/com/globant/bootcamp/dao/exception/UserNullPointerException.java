package com.globant.bootcamp.dao.exception;

public class UserNullPointerException extends RuntimeException {

    private static final long serialVersionUID = -146617257917447445L;
  
    public UserNullPointerException() {
      super("User could not be found empty");
    }
    
}