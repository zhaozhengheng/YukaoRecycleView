package com.bawei.yukaoRecycleView.bean;

/**
 * Created by 1 on 2017/4/1.
 */
public class Erjixia
{
    private String name;

    public Erjixia(String name) {
        this.name = name;
    }

    public Erjixia() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Erjixia{" +
                "name='" + name + '\'' +
                '}';
    }
}
