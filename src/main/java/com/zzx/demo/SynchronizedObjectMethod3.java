package com.zzx.demo;

/**
 * @ClassName SynchronizedObjectCodeBlock2
 * @Description 对象锁示例1，代码块形式
 * @Author zhangzx
 * @Date 2019/12/17 20:05
 * Version 1.0
 **/
public class SynchronizedObjectMethod3 implements Runnable {

    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }

    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("我的对象锁的方法修饰符形式。我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 运行结束");

    }
}

