package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Parent implements Serializable {
    @SerializedName("id")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
