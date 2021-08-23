package com.example.testfinerio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProfileResponse implements Serializable {
    @SerializedName("id")
    String id;
    @SerializedName("accountExpired")
    boolean accountExpired;
    @SerializedName("accountLocked")
    boolean accountLocked;
    @SerializedName("customerId")
    int customerId;
    @SerializedName("dateCreated")
    String dateCreated;
    @SerializedName("email")
    String email;
    @SerializedName("enabled")
    boolean enabled;
    @SerializedName("lastUpdated")
    String lastUpdated;
    @SerializedName("name")
    String name;
    @SerializedName("notificationsEnabled")
    boolean notificationsEnabled;
    @SerializedName("passwordExpired")
    boolean passwordExpired;
    @SerializedName("signupCredentialEmailSent")
    boolean signupCredentialEmailSent;
    @SerializedName("signupCredentialPushSent")
    boolean signupCredentialPushSent;
    @SerializedName("signupEmailSent")
    boolean signupEmailSent;
    @SerializedName("signupFrom")
    String signupFrom;
    @SerializedName("termsAndConditionsAccepted")
    boolean termsAndConditionsAccepted;
    @SerializedName("type")
    String type;
    @SerializedName("finerioCode")
    String finerioCode;
    @SerializedName("hasNewTerms")
    boolean hasNewTerms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public boolean isPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public boolean isSignupCredentialEmailSent() {
        return signupCredentialEmailSent;
    }

    public void setSignupCredentialEmailSent(boolean signupCredentialEmailSent) {
        this.signupCredentialEmailSent = signupCredentialEmailSent;
    }

    public boolean isSignupCredentialPushSent() {
        return signupCredentialPushSent;
    }

    public void setSignupCredentialPushSent(boolean signupCredentialPushSent) {
        this.signupCredentialPushSent = signupCredentialPushSent;
    }

    public boolean isSignupEmailSent() {
        return signupEmailSent;
    }

    public void setSignupEmailSent(boolean signupEmailSent) {
        this.signupEmailSent = signupEmailSent;
    }

    public String getSignupFrom() {
        return signupFrom;
    }

    public void setSignupFrom(String signupFrom) {
        this.signupFrom = signupFrom;
    }

    public boolean isTermsAndConditionsAccepted() {
        return termsAndConditionsAccepted;
    }

    public void setTermsAndConditionsAccepted(boolean termsAndConditionsAccepted) {
        this.termsAndConditionsAccepted = termsAndConditionsAccepted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFinerioCode() {
        return finerioCode;
    }

    public void setFinerioCode(String finerioCode) {
        this.finerioCode = finerioCode;
    }

    public boolean isHasNewTerms() {
        return hasNewTerms;
    }

    public void setHasNewTerms(boolean hasNewTerms) {
        this.hasNewTerms = hasNewTerms;
    }
}
