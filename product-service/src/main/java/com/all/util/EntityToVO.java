package com.all.util;

import com.all.entity.ProductInfo;
import com.all.vo.ProductInfoVO;

/**
 * 实体类转VO
 */
public class EntityToVO {

    /**
     * ProductInfo 转 ProductInfoVO
     */
    public static ProductInfoVO ProductInfoToProductInfoVO(ProductInfo productInfo){
        ProductInfoVO result = new ProductInfoVO();
        result.setId(productInfo.getProductId());
        result.setDescription(productInfo.getProductDescription());
        result.setName(productInfo.getProductName());
        result.setIcon(productInfo.getProductIcon());
        result.setPrice(productInfo.getProductPrice());
        result.setStock(productInfo.getProductStock());
        return result;
    }

}