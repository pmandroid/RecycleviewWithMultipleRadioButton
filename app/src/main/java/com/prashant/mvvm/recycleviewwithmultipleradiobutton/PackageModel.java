package com.prashant.mvvm.recycleviewwithmultipleradiobutton;

import java.util.List;

class PackageModel {
    private String name;
    private int id;
    private Boolean isYes;
    private Boolean isNo;


    public PackageModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getYes() {
        return isYes;
    }

    public void setYes(Boolean yes) {
        isYes = yes;
    }

    public Boolean getNo() {
        return isNo;
    }

    public void setNo(Boolean no) {
        isNo = no;
    }
}
