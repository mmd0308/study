package com.hzqing.study.singleton;

/**
 * @author hzqing
 * @date 2019-07-01 12:14
 */
public class ThreadLocalSingleton {
    private ThreadLocalSingleton(){

    }

    private static  ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }

}
