package com.hzqing.abastractfactory;

/**
 * 苹果生产厂
 * @author hzqing
 * @date 2019-06-30 15:32
 */
public class AppleFactory implements ElFactory {

    /**
     * 生产笔记本
     * @return
     */
    @Override
    public NoteBook produceNoteBook() {
        return new Mac();
    }

    /**
     * 生产台式机
     * @return
     */
    @Override
    public DesktopComputer produceComputer() {
        return new IMac();
    }

    /**
     * 生产手机
     * @return
     */
    @Override
    public Phone producePhone() {
        return new Iphone();
    }
}
