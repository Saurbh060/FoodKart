package com.foodkart.models;

public class User {
    private String userId;
    private String name;
    private String gender;
    private String phoneNumber;
    private String pincode;

    public User(String userId, String name, String gender, String phoneNumber, String pincode) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}