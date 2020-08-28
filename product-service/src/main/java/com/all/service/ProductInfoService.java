package com.all.service;

import com.all.entity.ProductInfo;
import com.all.vo.PageVO;
import com.all.vo.ProductManageVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author com.all
 * @since 2020-08-20
 */
public interface ProductInfoService extends IService<ProductInfo> {
    public boolean subStock(Integer productId,Integer quantity);
    public PageVO<List<ProductManageVO>> findProductManageVOByPage(Integer page, Integer size);
    public ProductManageVO findById(Integer id);
    public boolean updateProductManageVO(ProductManageVO productManageVO);
    public boolean updateStatus(Integer id,Boolean status);
}
