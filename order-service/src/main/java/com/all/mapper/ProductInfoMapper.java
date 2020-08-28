package com.all.mapper;

import com.all.entity.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author com.all
 * @since 2020-08-20
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    public BigDecimal getPriceById(Integer id);
}
