package com.hzqing.abastractfactory;

/**
 * @author hzqing
 * @date 2019-06-30 16:44
 */
public class Customer {
    public static void main(String[] args) {
        // 生产一台苹果台式机
        ElFactory applyFactory = new AppleFactory();
        DesktopComputer imac = applyFactory.produceComputer();
        imac.sendMail();

        // 生产一个vivo手机
        ElFactory vivoFctory = new VivoFactory();
        Phone vivo = vivoFctory.producePhone();
        vivo.sendMessage();

        // 生产一个thinkpad 笔记本
        ElFactory thinkpadFactory = new ThinkFactory();
        NoteBook thinkpad = thinkpadFactory.produceNoteBook();
        thinkpad.start();
    }
}
