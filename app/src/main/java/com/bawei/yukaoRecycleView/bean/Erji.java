package com.bawei.yukaoRecycleView.bean;

import java.util.List;

/**
 * Created by 1 on 2017/4/1.
 */
public class Erji
{
    private String cname;
    private List<Erjixia> list;
    private boolean boo;

    public Erji(String cname, List<Erjixia> list) {
        this.cname = cname;
        this.list = list;
    }

    public Erji() {
        super();
    }

    public boolean isBoo() {
        return boo;
    }

    public void setBoo(boolean boo) {
        this.boo = boo;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Erjixia> getList() {
        return list;
    }

    public void setList(List<Erjixia> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Erji{" +
                "cname='" + cname + '\'' +
                ", list=" + list +
                '}';
    }
}
