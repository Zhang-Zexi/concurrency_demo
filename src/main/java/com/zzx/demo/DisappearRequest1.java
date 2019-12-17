package com.zzx.demo;

/**
 * @ClassName DisappearRequest1
 * @Description 消息的请求
 * @Author zhangzx
 * @Date 2019/12/17 19:55
 * Version 1.0
 **/
public class DisappearRequest1 implements Runnable {

    static DisappearRequest1 instance = new DisappearRequest1();

    static final Object object = new Object();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    public void run() {
        synchronized (DisappearRequest1.class) {
            for (int j = 0; j < 100000; j ++) {
                i++;
            }
        }
    }
}
