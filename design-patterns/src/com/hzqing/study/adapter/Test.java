package com.hzqing.study.adapter;

/**
 * @author hzqing
 * @date 2019-07-05 08:38
 */
public class Test {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5();
    }
}
