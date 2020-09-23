package com.hhy.sell.dataobject.mapper;

import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface ProductCategoryMapper {
    @Insert("INSERT INTO product_category (category_name,category_type) VALUES (#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);
}
