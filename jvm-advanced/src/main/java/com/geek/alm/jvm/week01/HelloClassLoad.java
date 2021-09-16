package com.geek.alm.jvm.week01;

import java.io.*;

/**
 * @auther Alm
 * @create 2021/9/16 21:48:06
 */
public class HelloClassLoad extends ClassLoader {
    public static void main(String[] args) throws Exception {
        Class classz = new HelloClassLoad().findClass("Hello");
        //通过反射
        classz.getMethod("hello").invoke(classz.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        String fileLast = ".xlass";
        try(InputStream fis = this.getClass().getResourceAsStream("/jvm/"+name+fileLast)) {
            int length = fis.available();
            System.out.println("length:"+length);
            byte[] bytes = new byte[length];
            fis.read(bytes,0,length);
            fis.close();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (0b011111111 - bytes[i]);
//                System.out.print(bytes[i]);
            }
            System.out.println();
            return defineClass(name, bytes, 0, length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
