package com.hhy.sell.VO;

import lombok.Data;

/**
 * HTTP返回的最外层对象
 * @author OceansHan
 * @date 2020/9/16 15:38
 */
@Data
public class ResultVO<T> {
    /*返回状态码*/
    private Integer code;

    /* 提示信息*/
    private String msg;

   /* 返回的具体对象*/
    private T data;
}
