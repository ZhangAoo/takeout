package com.all.service.impl;

import com.all.entity.OrderDetail;
import com.all.form.OrderForm;
import com.all.service.OrderMasterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderMasterServiceImplTest {
   @Autowired
    private OrderMasterService orderMasterService;
    @Test
    void create() {
        OrderForm orderForm = new OrderForm();
        orderForm.setName("张三");
        orderForm.setPhone("12312312");
        orderForm.setAddress("666");
        orderForm.setId("sdfsadf111");
        List<OrderDetail> list = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId(1);
        orderDetail.setProductQuantity(3);
        list.add(orderDetail);
        orderDetail = new OrderDetail();
        orderDetail.setProductId(3);
        orderDetail.setProductQuantity(10);
        list.add(orderDetail);
        orderForm.setItems(list);
        this.orderMasterService.create(orderForm);
    }
}