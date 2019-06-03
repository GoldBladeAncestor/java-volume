package com;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 19:43 2019/5/13
 */
public class List<E>{
    private Object []data;//
    private int size = 0;//List当前大小
    private static final int DEFAULT_SIZE = 10;//默认的list大小

    public List(){
        this(DEFAULT_SIZE);
    }

    public List(int size){
        if (size < 0){
            throw new IllegalArgumentException("非法的集合容量llegal size:" + size);
        }else{
            this.data = new Object[size];
        }
    }

    /**
     * 判断下标是否越界
     * @param index
     * @return
     */
    public void checkIndexAndAdd(int index, E obj){
        int length = this.data.length;
        if(length <= index){
            Object []object = new Object[length * 2];
            System.arraycopy(this.data,0,object,0,length);
            object[index] = obj;
            this.data = object;
        }else{
            this.data[index] = obj;
        }
        size ++;
    }
    /**
     * 获取list大小
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * 向list添加元素
     * @param object
     */
    public void add(E object){
        checkIndexAndAdd(size,object);
    }

    public void add(int index,E object){
        if(index == size){
            add(object);
        }else{
            checkIndexAndAdd(index, object);
        }
    }

    /**
     * 删除指定元素
     * @param index
     */
    public Object remove(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("指定的index:" + index + "超出当前size:"+ size);
        }
        Object object = this.data[index];
        if(index == size){
            this.data[index] = null;
        }else{
            System.arraycopy(this.data,index + 1,this.data,index,size - index);
        }
        size --;
        return object;
    }

    /**
     * 删除全部元素
     */
    public void removeAll(){
        data = new Object[DEFAULT_SIZE];
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public Object get(int index){
        if(index >= size){
            throw new IndexOutOfBoundsException("指定的index:" + index + "超出当前size:"+ size);
        }
        return this.data[index];
    }

}
