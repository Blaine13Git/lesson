package com.study.lion.lesson.aboutMap.AboutHashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map data = new HashMap<>();
        data.put(1, "a");
        data.put(2, "b");
        System.out.println(data.get(1));
    }
}
