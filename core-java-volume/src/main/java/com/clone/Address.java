package com.clone;

import java.io.Serializable;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 16:28 2019/5/16
 */
public class Address implements Serializable {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
