package com.hzqing.study.prototype.shallow;

/**
 * @author hzqing
 * @date 2019-07-02 11:16
 */
public class Person implements Cloneable{
    private String name;

    private Compony compony;


    public Person(String name, Compony compony) {
        this.name = name;
        this.compony = compony;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public Compony getCompony() {
        return compony;
    }
}
