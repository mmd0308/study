package com.hzqing.study.abastractfactory;

/**
 * @author hzqing
 * @date 2019-06-30 15:21
 */
public class Vivo implements Phone {
    /**
     * vivo手机
     */
    @Override
    public void sendMessage() {
        System.out.println("Vivo 手机发送消息");
    }
}
