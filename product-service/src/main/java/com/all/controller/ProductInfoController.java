package com.all.controller;


import com.all.entity.ProductInfo;
import com.all.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author southwind
 * @since 2020-08-20
 */
@RestController
@RequestMapping("//productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public List<ProductInfo> list(){
        return this.productInfoService.list();
    }

    @PutMapping("/subStock/{id}/{quantity}")
    public boolean subStock(@PathVariable("id") Integer id,@PathVariable("quantity") Integer quantity){
        return this.productInfoService.subStock(id, quantity);
    }

}

