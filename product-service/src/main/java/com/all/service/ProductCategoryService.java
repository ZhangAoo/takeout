package com.all.service;

import com.all.entity.ProductCategory;
import com.all.vo.ProductCategoryVO;
import com.all.vo.ResultVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 类目表 服务类
 * </p>
 *
 * @author com.all
 * @since 2020-08-20
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    public ResultVO<List<ProductCategoryVO>> voList();
    public List<ProductCategoryVO> getAllCategoryVO();

}
