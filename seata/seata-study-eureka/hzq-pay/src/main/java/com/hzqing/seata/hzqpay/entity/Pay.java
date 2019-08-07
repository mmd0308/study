package com.hzqing.seata.hzqpay.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;

    private int amount;

    /**
     * 订单id
     */
    private int orderId;

    private LocalDateTime createTime;


}
