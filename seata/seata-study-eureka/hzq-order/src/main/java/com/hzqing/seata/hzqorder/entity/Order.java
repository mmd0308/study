package com.hzqing.seata.hzqorder.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String orderCode;

    private LocalDateTime createTime;

    private int amount;


}
