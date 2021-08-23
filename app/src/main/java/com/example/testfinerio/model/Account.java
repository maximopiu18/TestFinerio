package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Account implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("availableBalance")
    int availableBalance;
    @SerializedName("balance")
    String balance;
    @SerializedName("dateCreated")
    String dateCreated;
    @SerializedName("deleted")
    boolean deleted;
    @SerializedName("lastUpdated")
    String lastUpdated;
    @SerializedName("name")
    String name;
    @SerializedName("number")
    String number;
    @SerializedName("type")
    String type;
    @SerializedName("user")
    User user;
    @SerializedName("institution")
    Institution institution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
