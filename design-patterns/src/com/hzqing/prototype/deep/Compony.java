package com.hzqing.prototype.deep;

import java.io.Serializable;

/**
 * @author hzqing
 * @date 2019-07-02 11:22
 */
public class Compony implements Serializable {
    private String name;

    public Compony(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
