package com.bawei.yukaoRecycleView.bean;

/**
 * Created by 1 on 2017/4/1.
 */
public class Right
{
    private String image;
    private String jieshao;

    public Right(String image, String jieshao) {
        this.image = image;
        this.jieshao = jieshao;
    }

    public Right() {
        super();
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
        return "Right{" +
                "image='" + image + '\'' +
                ", jieshao='" + jieshao + '\'' +
                '}';
    }
}
