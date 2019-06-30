package com.hzqing.abastractfactory;

/**
 * @author hzqing
 * @date 2019-06-30 15:29
 */
public class ThinkPad implements NoteBook {
    /**
     * ThinkPad 笔记本启动
     */
    @Override
    public void start() {
        System.out.println("think 笔记本启动...");
    }
}
