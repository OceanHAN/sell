package com.hhy.sell.service.impl;
import com.hhy.sell.dataobject.ProductInfo;
import com.hhy.sell.enums.ProductStatusEnum;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest extends TestCase {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void testFindOne() {
        ProductInfo one = productService.findOne("123456");
        Assert.assertEquals("123456",one.getProductId());
    }

    public void testFindUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void testFindAll() {
       /*构造page对象*/
        PageRequest request = PageRequest.of(1,10);
        Page<ProductInfo> all = productService.findAll(request);
        System.out.println(all.getTotalElements());
    }
    @Test
    public void testSave() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("12");
        productInfo.setProductName("全麦面包");
        productInfo.setProductPrice(new BigDecimal(6.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很健康的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}