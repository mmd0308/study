package com.hzqing.abastractfactory;


public class IMac implements DesktopComputer{
    /**
     * 苹果台式机 发送邮件
     */
    @Override
    public void sendMail() {
        System.out.println("imac 发送邮件");
    }
}