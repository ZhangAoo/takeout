package com.all.service;

import com.all.entity.OrderMaster;
import com.all.form.OrderForm;
import com.all.vo.OrderVO;
import com.all.vo.PageVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author com.all
 * @since 2020-08-21
 */
public interface OrderMasterService extends IService<OrderMaster> {
    public String create(OrderForm orderForm);
    public OrderVO getVOBuyerIdAndOrderId(String buyerId,String orderId);
    List<OrderVO> getVOListByBuyerId(String buyerId, Integer page, Integer size);
    public boolean cancel(String buyerId,String orderId);
    public boolean finish(String orderId);
    public boolean pay(String buyerId,String orderId);
    public PageVO<List<OrderMaster>> getOrderByPage(Integer page, Integer size);
    //卖家端处理订单接口
    public boolean handler(String type,String orderId);
}
