package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("amount")
    String amount;
    @SerializedName("balance")
    String balance;
    @SerializedName("customDate")
    String customDate;
    @SerializedName("customDescription")
    String customDescription;
    @SerializedName("date")
    String date;
    @SerializedName("dateCreated")
    String dateCreated;
    @SerializedName("deleted")
    boolean deleted;
    @SerializedName("description")
    String description;
    @SerializedName("duplicated")
    boolean duplicated;
    @SerializedName("hasConcepts")
    boolean hasConcepts;
    @SerializedName("inResume")
    boolean inResume;
    @SerializedName("lastUpdated")
    String lastUpdated;
    @SerializedName("type")
    String type;

    @SerializedName("concepts")
    Concepts concepts;
    @SerializedName("account")
    Account account;

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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCustomDate() {
        return customDate;
    }

    public void setCustomDate(String customDate) {
        this.customDate = customDate;
    }

    public String getCustomDescription() {
        return customDescription;
    }

    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDuplicated() {
        return duplicated;
    }

    public void setDuplicated(boolean duplicated) {
        this.duplicated = duplicated;
    }

    public boolean isHasConcepts() {
        return hasConcepts;
    }

    public void setHasConcepts(boolean hasConcepts) {
        this.hasConcepts = hasConcepts;
    }

    public boolean isInResume() {
        return inResume;
    }

    public void setInResume(boolean inResume) {
        this.inResume = inResume;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Concepts getConcepts() {
        return concepts;
    }

    public void setConcepts(Concepts concepts) {
        this.concepts = concepts;
    }
}
