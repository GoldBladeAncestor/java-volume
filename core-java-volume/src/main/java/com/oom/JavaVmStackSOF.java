package com.oom;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:23 2019/5/29
 */
public class JavaVmStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args) throws Throwable{
        JavaVmStackSOF oom = new JavaVmStackSOF();
        oom.stackLeak();
    }
}
