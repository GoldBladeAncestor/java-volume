package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 15:07 2019/5/29
 */
public class oom {
    static  class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
