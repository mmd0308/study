package com.hzqing.study.decorator;

/**
 * @author hzqing
 * @date 2019-07-08 14:28
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Pancake pancake = null;
        // 创建一个煎饼
        pancake = new BasePancake();

        // 给煎饼添加一个鸡蛋
        pancake = new PancakeWithEgg(pancake);

        // 再给煎饼添加一个香肠
        pancake = new PancakeWithSausage(pancake);

        System.out.println("最后的煎饼是："  + pancake.getMsg() );
        System.out.println("最后的价格是：" + pancake.getPrice());
    }
}
