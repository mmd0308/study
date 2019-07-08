package com.hzqing.decorator;

/**
 * @author hzqing
 * @date 2019-07-08 14:32
 */
public class PancakeWithSausage extends PancakeDecorator {

    public PancakeWithSausage(Pancake pancake) {
        super(pancake);
    }

    @Override
    public String getMsg() {
        return super.getMsg() + "，添加一个香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 3;
    }
}
