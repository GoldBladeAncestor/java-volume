package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:48 2019/5/29
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
