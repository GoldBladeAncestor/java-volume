package com.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 11:17 2019/5/30
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader c = ClassLoaderTest.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1 = c.getParent();
        System.out.println(c1);
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);

        Class<?> aClass = Class.forName("com.classloader.ClassLoaderTest");
        Class<ClassLoaderTest> classLoaderTestClass = ClassLoaderTest.class;


        Constructor<?>[] constructors = aClass.getConstructors();
        Object o = aClass.newInstance();

        Method getClass = aClass.getMethod("getClass");
        Object invoke = getClass.invoke(constructors);
        System.out.println(invoke);



    }
}
