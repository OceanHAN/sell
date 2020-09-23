package com.hhy.sell.dataobject.mapper;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest extends TestCase {
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void testInsertByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","师兄最帅");
        map.put("category_type","1");
       int a =  mapper.insertByMap(map);
        System.out.println("测试github提交");
    }
}