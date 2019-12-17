package com.zzx.demo;

/**
 * @ClassName SynchronizedObjectCodeBlock2
 * @Description 类锁的第二种形式，class形式
 * @Author zhangzx
 * @Date 2019/12/17 20:05
 * Version 1.0
 **/
public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    public void run() {
        method();
    }

    public void method() {
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("我是类锁第二种形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }
    }
}

