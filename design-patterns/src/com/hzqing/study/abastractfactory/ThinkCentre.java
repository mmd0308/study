package com.hzqing.study.abastractfactory;

/**
 * @author hzqing
 * @date 2019-06-30 15:26
 */
public class ThinkCentre implements DesktopComputer {
    /**
     * ThinkPad 台式机发送邮件
     */
    @Override
    public void sendMail() {
        System.out.println("thinkpad 台式机发送邮件");
    }
}
