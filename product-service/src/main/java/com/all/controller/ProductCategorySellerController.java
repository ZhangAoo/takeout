package com.all.controller;

import com.all.entity.ProductInfo;
import com.all.enums.ProductEnum;
import com.all.exception.ProductException;
import com.all.service.ProductCategoryService;
import com.all.service.ProductInfoService;
import com.all.util.ResultVOUtil;
import com.all.vo.PageVO;
import com.all.vo.ProductManageVO;
import com.all.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller/product")
@Slf4j
public class ProductCategorySellerController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/findAllProductCategory")
    public ResultVO findAllProductCategory(){
        Map map = new HashMap();
        map.put("content", this.productCategoryService.getAllCategoryVO());
        return ResultVOUtil.success(map);
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody ProductInfo productInfo){
        this.productInfoService.save(productInfo);
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageVO<List<ProductManageVO>> productManageVOByPage = this.productInfoService.findProductManageVOByPage(page, size);
        return ResultVOUtil.success(productManageVOByPage);
    }

    @DeleteMapping("/delete/{id}")
    public ResultVO delete(@PathVariable("id") Integer id){
        this.productInfoService.removeById(id);
        return ResultVOUtil.success(null);
    }
    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        if (id==null){
            log.info("【查询商品】，商品编号为空，id={}",id);
            throw new ProductException(ProductEnum.PRODUCT_ID_NULL);
        }
        ProductManageVO productManageVO = this.productInfoService.findById(id);
        return ResultVOUtil.success(productManageVO);
    }
    @PutMapping("/update")
    public ResultVO update(@RequestBody ProductManageVO productManageVO){
        boolean result = this.productInfoService.updateProductManageVO(productManageVO);
        if(!result) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @PutMapping("/updateStatus/{id}/{status}")
    public ResultVO updateStatus(@PathVariable("id") Integer id,@PathVariable("status") Boolean status){
        boolean result = this.productInfoService.updateStatus(id, status);
        if(!result) return ResultVOUtil.fail();
        return ResultVOUtil.success(status);
    }
}
