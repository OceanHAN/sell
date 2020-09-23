package com.hhy.sell.service.impl;

import com.hhy.sell.dataobject.ProductInfo;
import com.hhy.sell.enums.ProductStatusEnum;
import com.hhy.sell.repository.ProductInfoRepository;
import com.hhy.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OceansHan
 * @date 2020/9/11 14:32
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    /*客户端查看所以在架的商品,用到了枚举*/
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /*终端查看所以商品，带分页*/
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

   /* 增加方法*/
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
