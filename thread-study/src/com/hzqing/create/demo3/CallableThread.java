package com.hzqing.create.demo3;

import java.util.concurrent.Callable;

/**
 * @author hzqing
 * @date 2019-07-13 11:08
 */
public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        int a = 1;
        int b = 3;
        return "线程的执行结果是： " + (a + b);
    }
}
