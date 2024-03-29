package com.zzx.demo;

/**
 * @ClassName SynchronizedRecursion10
 * @Description 可重入粒度测试：调用父类的方法
 * @Author zhangzx
 * @Date 2019/12/17 21:55
 * Version 1.0
 **/
public class SynchronizedSuperClass12 {

    public static void main(String[] args) {
        TestClass s = new TestClass();
        s.doSomething();
    }

    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }
}

class TestClass extends SynchronizedSuperClass12 {

    public synchronized void doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }

}
