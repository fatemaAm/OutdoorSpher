package com.example.outdoorsphere;

import androidx.annotation.NonNull;

public class Information {
    private String name;
    private String nametype;
    private int image;
    private String info;
    private String advice;

    public Information(String nametype, String name,int image, String info, String advice) {
        this.nametype = nametype;
        this.image = image;
        this.info = info;
        this.advice = advice;
        this.name = name;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    @NonNull
    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", nametype='" + nametype + '\'' +
                ", image=" + image +
                ", info='" + info + '\'' +
                ", location='" + advice + '\'' +
                '}';
    }
}
