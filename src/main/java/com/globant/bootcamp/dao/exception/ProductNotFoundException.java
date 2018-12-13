package com.globant.bootcamp.dao.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -146617257917447445L;
    private final Long productid;

    public ProductNotFoundException(final long productid) {
        super("Product could not be found with id: " + productid);
        this.productid = productid;
    }

    public Long getId() {
        return this.productid;
    }

}