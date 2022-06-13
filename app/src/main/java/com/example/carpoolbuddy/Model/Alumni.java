package com.example.carpoolbuddy.Model;

import java.util.ArrayList;

public class Alumni extends User {
    private String graduateYear;

    public Alumni(String uid, String name, String email, String password, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, String graduateYear) {
        super(uid, name, email, password, userType, priceMultiplier, ownedVehicles);
        this.graduateYear = graduateYear;
    }


    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public void printInfo(){
        super.printInfo();
        toString();
    }

    @Override
    public String toString() {
        return "Alumni{" +
                "uid=" + getUid() +
                "name=" + getName() +
                "email=" + getEmail() +
                "userType=" + getUserType() +
                "priceMultiplier=" + getPriceMultiplier() +
                "ownedVehicles=" + getOwnedVehicles() +
                "graduateYear='" + graduateYear + '\'' +
                '}';
    }
}
