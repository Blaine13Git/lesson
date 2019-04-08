package com.study.lion.lesson.aboutExam;

public class Exam004 implements Runnable {
    static PingPong pp = new PingPong();

    @Override
    public void run() {
        pp.hit(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        new Thread(new Exam004()).start();
        new Thread(new Exam004()).start();


    }
}

class PingPong {
    synchronized void hit(long n) {
        for (int i = 1; i < 3; i++) {
            System.out.print(n + "-" + i + " ");
        }
    }
}
