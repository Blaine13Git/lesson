package com.study.lion.lesson.aboutReflection;

import com.study.lion.lesson.aboutNew.AboutLambda;

import java.lang.reflect.Method;

public class ReflectionMain {

    static long start;

    public static void main(String[] args) {
        try {
            //通过类的全路径由classloader反射获取类
            start = System.currentTimeMillis();
            Class c1 = Class.forName("com.study.lion.lesson.aboutReflection.ForReflection");
            ForReflection forReflection1 = (ForReflection) c1.newInstance();
            System.out.println("Class.forName 耗时：" + (System.currentTimeMillis() - start));

            forReflection1.function01("OK");

            Method[] methods = c1.getMethods();
            System.out.println("c.methods:");
            for (Method method : methods) {
                System.out.println(method.getName());
            }

            //parameterTypes the parameter array
            Class[] parameterType = new Class[]{String.class};
            Method method = c1.getDeclaredMethod("function02", parameterType);
            method.setAccessible(true);
            method.invoke(forReflection1, "OK!!!!!!");

            //通过对象反射获取类
            start = System.currentTimeMillis();
            ForReflection forReflection = new ForReflection();
            System.out.println("new 耗时：" + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            Class<? extends ForReflection> c2 = forReflection.getClass();
            ForReflection forReflection2 = c2.newInstance();
            System.out.println("xxx.getClass 耗时：" + (System.currentTimeMillis() - start));

            //类的反射获取实例
            start = System.currentTimeMillis();
            Class<ForReflection> c3 = ForReflection.class;
            ForReflection forReflection3 = c3.newInstance();
            System.out.println("xxx.Class 耗时：" + (System.currentTimeMillis() - start));
            forReflection3.function01("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            AboutLambda aboutLambda = AboutLambda.class.newInstance();
            System.out.println(aboutLambda.hashCode());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class ForReflection {

    public void function01(String arg) {
        System.out.println(arg);
    }

    private void function02(String arg) {
        System.out.println(arg);
    }
}
