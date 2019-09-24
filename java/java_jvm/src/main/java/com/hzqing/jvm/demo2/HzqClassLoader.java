package com.hzqing.jvm.demo2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author hzqing
 * @date 2019-09-24 15:31
 */
public class HzqClassLoader extends ClassLoader {
    // classLoader 的名称
    private final String name = "HzqClassLoader";




    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] bytes = loadeClassData(className);
        return defineClass(className,bytes,0,bytes.length);
    }


    private byte[] loadeClassData(String className){
        byte [] data = null;
        try{
            FileInputStream is = new FileInputStream(new File(className.replaceAll(".","/" ) + ".class"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int ch = 0 ;
            while (-1 != (ch = is.read())){
                outputStream.write(ch);
            }
            data = outputStream.toByteArray();

            is.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }


}
