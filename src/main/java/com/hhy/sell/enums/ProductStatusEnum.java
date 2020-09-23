package com.hhy.sell.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 * @author OceanHan
 * @date 2020/9/11 14:55
 * @return
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private final Integer code;
    private final String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
