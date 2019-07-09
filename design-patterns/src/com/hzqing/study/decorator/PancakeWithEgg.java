package com.hzqing.study.decorator;

/**
 * @author hzqing
 * @date 2019-07-08 14:26
 */
public class PancakeWithEgg extends  PancakeDecorator {

    public PancakeWithEgg(Pancake pancake) {
        super(pancake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + ",加一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
