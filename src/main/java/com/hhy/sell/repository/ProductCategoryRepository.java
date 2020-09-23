package com.hhy.sell.repository;

import com.hhy.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * dao
 * @author OceanHan
 * @date 2020/9/2 15:52
 * @return
 */
public interface ProductCategoryRepository extends JpaRepository <ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryByTypeList);
}
