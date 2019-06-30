package com.hzqing.abastractfactory;

/**
 * Vivo 生产厂
 * @author hzqing
 * @date 2019-06-30 15:33
 */
public class VivoFactory implements ElFactory {
    /**
     * 不上产笔记本
     * @return
     */
    @Override
    public NoteBook produceNoteBook() {
        throw new RuntimeException("不生产笔记本");
    }

    /**
     * 不生产台式机
     * @return
     */
    @Override
    public DesktopComputer produceComputer() {
        throw new RuntimeException("不生产台式机");
    }

    /**
     * 生产手机
     * @return
     */
    @Override
    public Phone producePhone() {
        return new Vivo();
    }
}
