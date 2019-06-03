package com;

import org.junit.Test;



/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 20:20 2019/5/4
 */
public class TestStack {
    @Test
    public void testStack(){
        Stack<String> stack = new Stack();
        stack.add("123");
        stack.add("1234");
        stack.add("12345");
        stack.add("123456");
        stack.add("1234567");
        for (int i = 0; i < 4; i++) {
            String poll = stack.poll();
            System.out.println("poll:"+poll);
        }
        String poll = stack.poll();
        System.out.println("poll:"+poll);
        stack.clean();
        poll = stack.poll();
        System.out.println("poll:"+poll);
    }
}

class Stack<E>{
    private int index;
    private List list;
    public Stack(){
        index = -1;
        list = new List();
    }

    public void add(E e){
        list.add(e);
        index ++;
    }

    public E poll(){
        if(index > -1){
            E e = (E) list.get(index);
            list.remove(index);
            index --;
            return e;
        }else{
           throw new NullPointerException();
        }
    }

    public E peek(){
        if(index > -1){
            return (E) list.get(index -1);
        }else{
            throw new NullPointerException();
        }

    }

    public void clean(){
        index = -1;
        list = new List();
    }
}
