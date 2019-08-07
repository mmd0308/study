package com.hzqing.seata.hzqpay.service.impl;

import com.hzqing.seata.hzqpay.entity.Pay;
import com.hzqing.seata.hzqpay.mapper.PayMapper;
import com.hzqing.seata.hzqpay.service.IPayService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-08-07
 */
@Service
public class PayServiceImpl implements IPayService {

    @Autowired
    PayMapper payMapper;


    @Override
    public void save(Pay pay) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        payMapper.insert(pay);
    }
}
