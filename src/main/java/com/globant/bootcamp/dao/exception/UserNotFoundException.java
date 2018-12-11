package com.globant.bootcamp.dao.exception;


public class UserNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = -146617257917447445L;
    private final Long userid;
  
    public UserNotFoundException(final long userid) {
      super("User could not be found with id: " + userid);
      this.userid = userid;
    }
    
    public Long getId(){return this.userid;}
      
}