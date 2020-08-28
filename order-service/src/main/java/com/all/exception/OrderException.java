package com.all.exception;

import com.all.enums.OrderEnum;

public class OrderException extends RuntimeException {

    public OrderException(OrderEnum orderEnum) {
        super(orderEnum.getMsg());
    }
}
