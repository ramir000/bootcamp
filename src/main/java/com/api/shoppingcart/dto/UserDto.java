package com.api.shoppingcart.dto;

public class UserDto {

    private Long userId;

    private String uname;

    public UserDto(Long userId, String uname) {
        this.userId = userId;
        this.uname = uname;
    }

    public UserDto() {
    }

    public Long getId() {
        return this.userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

}