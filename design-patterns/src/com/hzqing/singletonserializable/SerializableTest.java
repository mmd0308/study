package com.hzqing.singletonserializable;

import java.io.*;

/**
 * @author hzqing
 * @date 2019-07-01 13:11
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception {
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = null;

        FileOutputStream outputStream = new FileOutputStream("LazySingleton.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(singleton1);
        objectOutputStream.flush();
        objectOutputStream.close();
        outputStream.close();

        FileInputStream inputStream = new FileInputStream("LazySingleton.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        singleton2 = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();


        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);

    }
}
