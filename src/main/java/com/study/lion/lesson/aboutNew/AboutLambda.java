package com.study.lion.lesson.aboutNew;

public class AboutLambda {
    public static void main(String[] args) {
        TestLambda tl = () -> System.out.println("OK");
        tl.add();
    }

}

@FunctionalInterface
interface TestLambda {
    void add();

//    void max();
}

