package com.bawei.yukaoRecycleView.bean;

/**
 * Created by 1 on 2017/4/1.
 */
public class Zhong
{
    private String name;
    private String image;
    private String jieshao;

    public Zhong(String name, String image, String jieshao) {
        this.name = name;
        this.image = image;
        this.jieshao = jieshao;
    }

    public Zhong() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    @Override
    public String toString() {
        return "Zhong{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", jieshao='" + jieshao + '\'' +
                '}';
    }
}
