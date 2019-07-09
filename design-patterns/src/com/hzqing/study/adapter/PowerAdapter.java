package com.hzqing.study.adapter;

/**
 * @author hzqing
 * @date 2019-07-05 08:35
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5() {
        int adapterInput = ac220.outputAC220V();
        int outputDC5 = adapterInput/44;
        System.out.println("使用PowerAdapter适配器输入交流电：" + adapterInput + "V,输出直流电：" + outputDC5 + "V");
        return outputDC5;
    }
}
