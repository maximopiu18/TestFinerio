package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Concepts implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("amount")
    String amount;
    @SerializedName("description")
    String description;
    @SerializedName("type")
    String type;
    @SerializedName("movement")
    String movement;
    @SerializedName("category")
    ArrayList<Category> categoty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public ArrayList<Category> getCategoty() {
        return categoty;
    }

    public void setCategoty(ArrayList<Category> categoty) {
        this.categoty = categoty;
    }
}
