package com.hzqing.abastractfactory;

/**
 * ThinkPad 生产厂
 * @author hzqing
 * @date 2019-06-30 15:34
 */
public class ThinkFactory implements ElFactory {
    /**
     * 生产笔记
     * @return
     */
    @Override
    public NoteBook produceNoteBook() {
        return new ThinkPad();
    }

    /**
     * 生产台式机
     * @return
     */
    @Override
    public DesktopComputer produceComputer() {
        return  new ThinkCentre();
    }

    /**
     * 不生产手机
     * @return
     */
    @Override
    public Phone producePhone() {
        throw new RuntimeException("不生产手机");
    }
}
