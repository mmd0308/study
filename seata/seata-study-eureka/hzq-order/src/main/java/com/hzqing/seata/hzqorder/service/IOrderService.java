package com.hzqing.seata.hzqorder.service;

import com.hzqing.seata.hzqorder.entity.Order;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-08-07
 */
public interface IOrderService {

    void save(Order order);
}
