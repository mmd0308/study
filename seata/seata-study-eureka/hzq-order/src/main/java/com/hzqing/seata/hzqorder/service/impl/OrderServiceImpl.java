package com.hzqing.seata.hzqorder.service.impl;

import com.hzqing.seata.hzqorder.entity.Order;
import com.hzqing.seata.hzqorder.mapper.OrderMapper;
import com.hzqing.seata.hzqorder.service.IOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-08-07
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    RestTemplate restTemplate;


    @Override
    //@GlobalTransactional(timeoutMills = 300000, name = "hzq-order")
    @GlobalTransactional
    public void save(Order order) {
        System.out.println("全局事务id ：" + RootContext.getXID());

        orderMapper.insert(order);
        // 调用订单服务
        HashMap<String,Object> pay = new HashMap<>();
        pay.put("amount",order.getAmount());
        pay.put("orderId",order.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity = new HttpEntity(pay,headers);
        restTemplate.exchange("http://localhost:8080/pay/add", HttpMethod.POST,httpEntity,Object.class);


        //  出现异常
        System.out.println(1/0);
    }
}
