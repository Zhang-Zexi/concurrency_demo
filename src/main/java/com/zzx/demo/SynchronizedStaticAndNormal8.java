package com.zzx.demo;

/**
 * @ClassName SynchronizedYesAndNo6
 * @Description 同时访问静态的synchronized和非静态的synchronized
 * @Author zhangzx
 * @Date 2019/12/17 21:12
 * Version 1.0
 **/
public class SynchronizedStaticAndNormal8 implements Runnable {

    static SynchronizedStaticAndNormal8 instance = new SynchronizedStaticAndNormal8();

    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized static void method1() { // 锁的是静态的class对象
        System.out.println("我是静态加锁的方法1。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");
    }

    public synchronized void method2() { // 锁的是这个实例this
        System.out.println("我是非静态加锁的方法2。我叫" + Thread.currentThread().getName());
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
