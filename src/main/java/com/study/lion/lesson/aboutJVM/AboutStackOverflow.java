package com.study.lion.lesson.aboutJVM;

/**
 * 递归调用要有出口
 * 防止Java虚拟机栈报错-->StackOverflowError
 * 由结果可以得到，递归调用会不断的把方法进行入栈操作
 */
public class AboutStackOverflow {

    private static void functionA() {
        functionA();
    }

    public static void main(String[] args) {
        functionA();
    }
}
