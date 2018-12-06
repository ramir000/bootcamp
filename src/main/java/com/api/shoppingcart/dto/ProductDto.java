package com.api.shoppingcart.dto;

public class ProductDto {

    private Long poductId;
    private String Pname;
    private Double price;

    public ProductDto() {
    }

    public ProductDto(Long id, String Pname, Double price) {
        this.poductId = id;
        this.Pname = Pname;
        this.price = price;
    }


    public Long getId() {
        return this.poductId;
    }

    public void setId(Long id) {
        this.poductId = id;
    }

    public String getPname() {
        return this.Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}