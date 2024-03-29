package com.zzx.demo;

/**
 * @ClassName SynchronizedYesAndNo6
 * @Description 同时访问一个类的不同的普通同步方法
 * @Author zhangzx
 * @Date 2019/12/17 21:12
 * Version 1.0
 **/
public class SynchronizedDifferenceMethod7 implements Runnable {

    static SynchronizedDifferenceMethod7 instance = new SynchronizedDifferenceMethod7();

    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("我是加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }

    public synchronized void method2() {
        System.out.println("我是没加锁的方法。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
