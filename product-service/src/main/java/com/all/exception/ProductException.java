package com.all.exception;

import com.all.enums.ProductEnum;

public class ProductException extends RuntimeException{
    public ProductException(ProductEnum productEnum) {
        super(productEnum.getMsg());
    }
}
