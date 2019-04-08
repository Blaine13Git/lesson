package com.study.lion.lesson.aboutArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Main {

    String name = "JJ";

    void test() {
        System.out.println("xxx");
    }

    public static void main(String[] args) {

        int[] arrayInt = {1, 26, 23, 2, 5};
        try {
            for (int i = 0; i < 6; i++) {
                int a = arrayInt[i];
                System.out.println(a);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        Main case01 = new Main();
        case01.test();
        case01.name = "OK";
        Arrays.parallelSort(arrayInt);
        Arrays.stream(arrayInt).forEach(i -> System.out.println(i));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("s");
        strings.add("a");
        strings.add("s");
        strings.add("q");

        Optional<String> s1 = strings.stream().filter(s -> s.equals("s")).findAny();
        if (s1.isPresent()) {
            System.out.println(s1.get());
        }
    }
}
