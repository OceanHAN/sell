package com.hhy.sell.repository;

import com.hhy.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品DAO
 * @author OceanHan
 * @date 2020/9/11 14:08
 * @return
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /*查询上架的商品*/
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
