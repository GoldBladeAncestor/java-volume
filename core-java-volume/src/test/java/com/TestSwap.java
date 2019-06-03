package com;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:05 2019/5/6
 */
public class TestSwap {
    @Test
    public void testSwap(){
        Integer a = 1;
        Integer b = 2;
        System.out.println("a=" + a + ",b=" + b);
        swap2(a,b);
        System.out.println("a=" + a + ",b=" + b);
    }
    public void swap(Integer mua,Integer mub) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int temp = mua.intValue();
            field.set(mua,mub.intValue());
            field.set(mub,new Integer(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void swap2(Integer mua,Integer mub) {
        try {
            Integer muc = new Integer(1);
            Field a =mua.getClass().getDeclaredField("value");
            a.setAccessible(true);
            a.set(mua,2);

            Field b =mua.getClass().getDeclaredField("value");
            b.setAccessible(true);
            b.set(mub,muc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
