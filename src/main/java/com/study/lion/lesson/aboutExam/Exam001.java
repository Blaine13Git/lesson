package com.study.lion.lesson.aboutExam;

import javax.management.timer.Timer;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam001 {

    public static void main(String[] args) throws Exception {
        case01Thread();
    }

    public static void case01Thread() throws InterruptedException {
        Object obj = new Object();
        Thread thread = Thread.currentThread();
        synchronized (thread) {
            obj.wait(); //IllegalMonitorStateException
            /*
            抛出此异常,表示线程已尝试在对象的监视器上等待，
            或者在没有指定监视器的情况下通知在对象监视器上等待的其他线程。
            应该是thread.wait(),或者锁thread换成锁obj
             */
            obj.notifyAll();
        }
    }

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() ThreadName="
                        + Thread.currentThread().getName());
                lock.wait();
                System.out.println("  end wait() ThreadName="
                        + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName="
                        + Thread.currentThread().getName() + " time="
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
