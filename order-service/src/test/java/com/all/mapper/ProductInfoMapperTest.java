package com.all.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductInfoMapperTest {
   @Autowired
   private ProductInfoMapper mapper;
    @Test
    void getPriceById() {
        BigDecimal price=this.mapper.getPriceById(1);
        int id=0;
    }
}