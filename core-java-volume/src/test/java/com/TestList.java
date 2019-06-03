package com;

import org.junit.Test;

import java.util.*;
import java.util.List;


/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 10:55 2019/5/7
 */
public class TestList {
    List list = new LinkedList();
    List list1 = new Vector();
    List list2 = new ArrayList();
    Set set = new HashSet();
    Map map = new HashMap();
    int i;
    String []a = {"1"};

    @Test
    public void testList(){
        String intern = "aaa".intern();
        System.out.println("aaa" == "aaa");
        System.out.println("aaa" == new String("aaa"));
        System.out.println(new String("aaa") == new String("aaa"));
        System.out.println("aaa" == intern);
        int s;
//        List<String> strings = Arrays.asList(a);
//        list = new ArrayList(strings);
//        list.add("1");
//
//        for (Object str:list) {
//            list.remove(str);
//        }
        list1.add(122);
//        int[] a = new int[3];
//        a[0] = 0;
//        a[1] = 1;
//        a[2] = 2;
//        int[] b = Arrays.copyOf(a, 10);
//        System.out.println("b.length"+b.length);
//        System.out.println("a.length"+a.length);
        System.out.println(Integer.highestOneBit(64));
    }

}
