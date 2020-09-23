package com.hhy.sell.service;

import com.hhy.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.stream.LongStream;

/**
 * @author OceansHan
 * @date 2020/9/10 14:50
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    //买家端进行使用的
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryByTypeList);

    ProductCategory save(ProductCategory productCategory);
}
