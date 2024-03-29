package com.geek.alm.jvm.classload;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.Enumeration;

/**
 * @auther Alm
 * @create 2021/9/14 23:45:03
 */
public class HelloClassLoadTest extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        try {
//            new HelloClassLoadTest().findClass("com.geek.alm.jvm.bytecode.Hello").newInstance();
//            new HelloClassLoadTest().findClass("com.geek.alm.jvm.bytecode.Hello").newInstance();
            Class classz =  new HelloClassLoadTest().findClass("Hello");
            classz.getMethod("hello").invoke(classz.newInstance());
        }catch (Exception e){
          e.printStackTrace();
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String base64Str = "NQFFQf///8v/4/X/+f/x9v/w/+/3/+71/+3/7Pj/6/j/6v7/+cOWkZaLwf7//NfWqf7/+7yQm5r+//CzlpGasYqSnZqNq56dk5r+//qXmpOTkP7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4/+nz/+j/5/7/7Leak5OQ09+ck56MjLOQnpuajd74/+bz/+X/5P7/+reak5OQ/v/vlZ6JntCTnpGY0LCdlZqci/7/75WeiZ7Qk56RmNCshoyLmpL+//yQiov+/+qzlZ6JntCWkNCvjZaRi6yLjZqeksT+/+yVnome0JaQ0K+NlpGLrIuNmp6S/v/4j42WkYuTkf7/6tezlZ6JntCTnpGY0KyLjZaRmMTWqf/e//r/+f///////f/+//j/9//+//b////i//7//v////rVSP/+Tv////7/9f////n//v////7//v/0//f//v/2////2v/9//7////2Tf/97fxJ//tO/////v/1////9f/9////+//3//r//v/z/////f/y";
        byte[] bytes = Base64.getDecoder().decode(base64Str);
        byte[] resultBytes = new byte[bytes.length];
        for(int i = 0;i<bytes.length;i++){
           resultBytes[i] =  (byte) (255 - bytes[i]);
        }
        return defineClass(name,resultBytes,0,resultBytes.length);
//        return loadClass(name);
    }
}
