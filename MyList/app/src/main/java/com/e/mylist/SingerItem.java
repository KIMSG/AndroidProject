package com.e.mylist;

public class SingerItem {
    String name;
    String mobile;
    int resId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public SingerItem(String name, String mobile, int resId){
        this.name = name;
        this.mobile = mobile;
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
