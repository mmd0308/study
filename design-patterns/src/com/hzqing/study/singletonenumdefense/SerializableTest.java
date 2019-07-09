package com.hzqing.study.singletonenumdefense;

import java.io.*;

/**
 * @author hzqing
 * @date 2019-07-02 08:20
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {

        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = null;

        FileOutputStream outputStream = new FileOutputStream("EnumSingleton.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(singleton1);
        objectOutputStream.flush();
        objectOutputStream.close();
        objectOutputStream.close();

        FileInputStream inputStream = new FileInputStream("EnumSingleton.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        singleton2 = (EnumSingleton) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();

        System.out.println(singleton1 == singleton2);

    }
}
