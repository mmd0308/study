package com.hzqing.study.decorator;

/**
 * @author hzqing
 * @date 2019-07-08 14:24
 */
public class BasePancake implements Pancake {
    @Override
    public String getMsg() {
        return "一个煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
