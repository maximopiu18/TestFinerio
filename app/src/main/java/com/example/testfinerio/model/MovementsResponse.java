package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovementsResponse implements Serializable {
    @SerializedName("data")
    ArrayList<Data> movements;
    @SerializedName("size")
    int size;

    public ArrayList<Data> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Data> movements) {
        this.movements = movements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
