package com.hzqing.abastractfactory;

/**
 * @author hzqing
 * @date 2019-06-30 15:21
 */
public class Iphone implements Phone {

    /**
     * 苹果手机
     */
    @Override
    public void sendMessage() {
        System.out.println("苹果手机，发送消息...");
    }
}
