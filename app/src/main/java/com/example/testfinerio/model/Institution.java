package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Institution implements Serializable {
    @SerializedName("id")
   private  int id;
    @SerializedName("code")
   private String code;
    @SerializedName("institutionType")
   private String institutionType;
    @SerializedName("name")
   private String name;
    @SerializedName("status")
   private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
