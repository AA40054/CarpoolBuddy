package com.example.carpoolbuddy.Model;

import java.util.ArrayList;

public class User {
    private String uid;
    private String name;
    private String email;
    private String password;
    private String userType;
    private double priceMultiplier;
    private ArrayList<String> ownedVehicles;


    public User(String uid, String name, String email, String password, String userType, double priceMultiplier, ArrayList<String> ownedVehicles) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.priceMultiplier = priceMultiplier;
        this.ownedVehicles = ownedVehicles;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){ return password;};

    public void setPassword(String password) {this.password = password;};

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public ArrayList<String> getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(ArrayList<String> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }

    public void printInfo(){
        System.out.println(this.uid + this.name + this.email + this.password + this.userType + this.priceMultiplier
        + this.ownedVehicles);
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", priceMultiplier=" + priceMultiplier +
                ", ownedVehicles=" + ownedVehicles +
                '}';
    }
}
