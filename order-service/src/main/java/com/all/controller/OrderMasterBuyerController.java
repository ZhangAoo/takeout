package com.all.controller;


import com.all.entity.OrderDetail;
import com.all.enums.OrderEnum;
import com.all.exception.OrderException;
import com.all.feign.ProductFeign;
import com.all.form.OrderForm;
import com.all.service.OrderMasterService;
import com.all.util.ResultVOUtil;
import com.all.vo.OrderVO;
import com.all.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author southwind
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class OrderMasterBuyerController {
//    @GetMapping("/index")
//    public String index(){
//      return "index";
//    }

    @Autowired
    private OrderMasterService orderMasterService;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("【创建订单】,参数异常,orderForm={}", orderForm);
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        //创建订单
        String orderId = this.orderMasterService.create(orderForm);
        if (orderId == null) {
            log.info("【创建订单】,创建失败,orderForm={}", orderForm);
            return ResultVOUtil.fail();
        }
        Map<String, String> data = new HashMap<>();
        data.put("orderId", orderId);
        return ResultVOUtil.success(data);
    }

    @GetMapping("/detail/{buyerId}/{orderId}")
    public ResultVO detail(@PathVariable("buyerId")String buyerId, @PathVariable("orderId") String orderId) {
        OrderVO orderVO = this.orderMasterService.getVOBuyerIdAndOrderId(buyerId, orderId);
        if (orderVO == null) return ResultVOUtil.fail();
        return ResultVOUtil.success(orderVO);
    }

    @GetMapping("/list/{buyerId}/{page}/{size}")
    public ResultVO list(@PathVariable("buyerId") String buyerId,
                         @PathVariable("page") Integer page,
                         @PathVariable("size") Integer size) {
        return ResultVOUtil.success(this.orderMasterService.getVOListByBuyerId(buyerId,page,size));
    }
    @PutMapping("/cancel/{buyerId}/{orderId}")
    public ResultVO cancel(@PathVariable("buyerId") String buyerId,@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.cancel(buyerId, orderId);
        if(result) return ResultVOUtil.success(null);
        return ResultVOUtil.fail();
    }

    @PutMapping("/finish/{orderId}")
    public ResultVO finish(@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.finish(orderId);
        if(result) return ResultVOUtil.success(null);
        return ResultVOUtil.fail();
    }

    @PutMapping("/pay/{buyerId}/{orderId}")
    public ResultVO pay(@PathVariable("buyerId") String buyerId,@PathVariable("orderId") String orderId){
        boolean result = this.orderMasterService.pay(buyerId, orderId);
        if(result) return ResultVOUtil.success(null);
        return ResultVOUtil.fail();
    }
}
