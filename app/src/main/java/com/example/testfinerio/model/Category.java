package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("color")
    String color;
    @SerializedName("name")
    String name;
    @SerializedName("textColor")
    String textColor;
    @SerializedName("parent")
    Parent parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
