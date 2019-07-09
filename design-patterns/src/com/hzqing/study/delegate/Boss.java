package com.hzqing.study.delegate;

/**
 * @author hzqing
 * @date 2019-07-03 13:51
 */
public class Boss {

    /**
     * 将命令下达给leader
     * @param commd
     * @param leader
     */
    public void commd(String commd,Leader leader){
        leader.doing(commd);
    }
}
