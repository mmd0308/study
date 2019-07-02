package com.hzqing.prototype.deep;

import java.io.*;

/**
 * @author hzqing
 * @date 2019-07-02 11:16
 */
public class Person implements Cloneable,Serializable{
    private String name;

    private Compony compony;


    public Person(String name, Compony compony) {
        this.name = name;
        this.compony = compony;
    }

    @Override
    protected Object clone() {
        return this.deepClone();
    }

    private Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(bos);
            outputStream.writeObject(this);

            ByteArrayInputStream ins = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream inputStream = new ObjectInputStream(ins);
            Person copy = (Person) inputStream.readObject();
            // 注意 copy的对象中公司是新建立的，但是名称还是应用。所以我们还需要修改
            copy.getCompony().setName(new String());
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public Compony getCompony() {
        return compony;
    }
}
