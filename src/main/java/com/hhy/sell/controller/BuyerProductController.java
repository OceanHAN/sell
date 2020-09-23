package com.hhy.sell.controller;

import com.hhy.sell.VO.ProductInfoVO;
import com.hhy.sell.VO.ProductVO;
import com.hhy.sell.VO.ResultVO;
import com.hhy.sell.dataobject.ProductCategory;
import com.hhy.sell.dataobject.ProductInfo;
import com.hhy.sell.service.CategoryService;
import com.hhy.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author OceansHan
 * @date 2020/9/16 15:34
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
       /* 1.查询所以的上架商品*/
        List<ProductInfo> ProductInfoList = productService.findUpAll();
        /*2.查询类目(一次性的查询)*/
        //使用java8特性 lambda进行遍历
        List<Integer> categoryTypeList = ProductInfoList.stream()
                .map(e -> e.getCategoryType()).
                        collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        /* 3.数据拼装*/
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            //类目
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            //商品详情
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : ProductInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //把productInfo的值 拷贝到productInfoVO里面
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            //把商品的数据集合添加到类目里面
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        /*返回数据的根节点*/
        ResultVO  resultVO= new  ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOList);
        return resultVO;
    }
}
