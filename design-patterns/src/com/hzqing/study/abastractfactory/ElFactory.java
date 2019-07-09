package com.hzqing.study.abastractfactory;

public interface ElFactory {
    /**
     * 生产笔记本
     * @return
     */
    NoteBook produceNoteBook();

    /**
     * 生产台式机
     * @return
     */
    DesktopComputer produceComputer();

    /**
     * 生产手机
     * @return
     */
    Phone producePhone();
}
