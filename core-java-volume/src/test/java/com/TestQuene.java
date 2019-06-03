package com;

import org.junit.Test;


/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:20 2019/5/4
 */
public class TestQuene {
    @Test
    public void testQuene(){
        Quene<String> quene = new Quene();
        quene.add("123");
        quene.add("1234");
        quene.add("12345");
        quene.add("123456");
        quene.add("1234567");
        for (int i = 0; i < 4; i++) {
            String poll = quene.poll();
            System.out.println("poll:"+poll);
        }
        String poll = quene.poll();
        System.out.println("poll:"+poll);
        quene.clean();
        poll = quene.poll();
        System.out.println("poll:"+poll);
    }
}

class Quene<E>{
    private List list;
    public Quene(){
        list = new List();
    }

    public void add(E e){
        list.add(e);
    }

    public E poll(){
        if(list.size() > 0){
            E e = (E) list.get(0);
            list.remove(0);
            return e;
        }else{
           throw new NullPointerException();
        }
    }

    public void clean(){
        list = new List();
    }
}
