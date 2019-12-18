package com.zzx.demo;

/**
 * @ClassName SynchronizedRecursion10
 * @Description 可重入粒度测试：调用类内另外的方法
 * @Author zhangzx
 * @Date 2019/12/17 21:55
 * Version 1.0
 **/
public class SynchronizedOtherMethod11 {

    int a = 0;

    public static void main(String[] args) {

        SynchronizedOtherMethod11 s = new SynchronizedOtherMethod11();
        s.method1();
    }

    private synchronized void method1() {
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("我是method2");
    }
}
