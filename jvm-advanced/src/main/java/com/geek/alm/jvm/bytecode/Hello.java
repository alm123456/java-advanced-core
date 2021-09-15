package com.geek.alm.jvm.bytecode;

/**
 * @auther Alm
 * @create 2021/9/14 09:51:11
 */
public class Hello {
    private static long num = 0L;
    private static int[] nums = {1,5,7};
    static {
        add();
    }
    public static void add(){
        Hello hello = new Hello();
        if(nums.length>0){
            for(int i:nums){
                addition(i);
            }
        }
        System.out.println(num);
    }

    private static void addition(long i) {
        num += i;
    }
}
