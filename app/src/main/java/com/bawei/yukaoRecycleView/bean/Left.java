package com.bawei.yukaoRecycleView.bean;

/**
 * Created by 1 on 2017/4/1.
 */
public class Left
{
    private String name;

    public Left(String name) {
        this.name = name;
    }

    public Left() {
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
        return "Left{" +
                "name='" + name + '\'' +
                '}';
    }
}
