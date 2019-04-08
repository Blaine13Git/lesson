package com.study.lion.lesson.aboutExam;

public class Exam002 {
    private int a;

    protected Exam002(int a) {
        this.a = a;
    }
}

class Sub extends Exam002 {

    protected Sub(int a) {
        super(a);
    }

    public Sub() {
        this(5000);
    }
}