package com.example.carpoolbuddy.Model;

import java.util.ArrayList;

public class Teacher extends User{
    private String inSchoolTitle;

    public Teacher(String uid, String name, String email, String password, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, String inSchoolTitle) {
        super(uid, name, email, password, userType, priceMultiplier, ownedVehicles);
        this.inSchoolTitle = inSchoolTitle;
    }


    public String getInSchoolTitle() {
        return inSchoolTitle;
    }

    public void setInSchoolTitle(String inSchoolTitle) {
        this.inSchoolTitle = inSchoolTitle;
    }

    public void printInfo(){
        super.printInfo();
        toString();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uid=" + getUid() +
                "name=" + getName() +
                "email=" + getEmail() +
                "userType=" + getUserType() +
                "priceMultiplier=" + getPriceMultiplier() +
                "ownedVehicles=" + getOwnedVehicles() +
                "inSchoolTitle='" + inSchoolTitle + '\'' +
                '}';
    }
}
