package com.zzx.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockExample15
 * @Description 展示Lock的方法
 * @Author zhangzx
 * @Date 2019/12/18 19:54
 * Version 1.0
 **/
public class LockExample15 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
//        lock.tryLock(1000, TimeUnit.SECONDS);
    }
}
