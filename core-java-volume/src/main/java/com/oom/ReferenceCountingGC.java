package com.oom;

import java.lang.ref.SoftReference;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 16:41 2019/5/29
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final  int _1MB = 1024*1024;

    public byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC obj1 = new ReferenceCountingGC();
        ReferenceCountingGC obj2 = new ReferenceCountingGC();

        obj1.instance = obj2;
        obj2.instance = obj1;

        System.gc();
    }

    public static void systemGC(){
        System.gc();
    }

    public static void main(String[] args) {
        final ReferenceCountingGC gc = new ReferenceCountingGC();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    gc.instance = 1;
                }
            }
        });
        systemGC();
        gc.bigSize = new byte[2 * 1024];
        SoftReference softReference = new SoftReference(new ReferenceCountingGC());
        systemGC();
    }
}
