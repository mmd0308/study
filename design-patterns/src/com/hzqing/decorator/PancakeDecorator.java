package com.hzqing.decorator;

/**
 * @author hzqing
 * @date 2019-07-08 14:25
 */
public class PancakeDecorator  implements Pancake{
    /**
     * 被装饰者
     */
    private Pancake pancake;

    public PancakeDecorator(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getMsg() {
        return pancake.getMsg();
    }

    @Override
    public int getPrice() {
        return pancake.getPrice();
    }
}
