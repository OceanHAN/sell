package com.hhy.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 * @author OceansHan
 * @date 2020/9/16 16:03
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String CategoryName;

    @JsonProperty("type")
    private Integer CategoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
