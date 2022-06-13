package com.example.carpoolbuddy.Model;

import java.util.ArrayList;

public class Parent extends User{
    private ArrayList<String> childrenUIDs;

    public Parent(String uid, String name, String email, String password, String userType, double priceMultiplier, ArrayList<String> ownedVehicles, ArrayList<String> childrenUIDs) {
        super(uid, name, email, password, userType, priceMultiplier, ownedVehicles);
        this.childrenUIDs = childrenUIDs;
    }


    public ArrayList<String> getChildrenUIDs() {
        return childrenUIDs;
    }

    public void setChildrenUIDs(ArrayList<String> childrenUIDs) {
        this.childrenUIDs = childrenUIDs;
    }

    public void printInfo(){
        super.printInfo();
        toString();
    }

    @Override
    public String toString() {
        return "Parent{" +
                "uid=" + getUid() +
                "name=" + getName() +
                "email=" + getEmail() +
                "userType=" + getUserType() +
                "priceMultiplier=" + getPriceMultiplier() +
                "ownedVehicles=" + getOwnedVehicles() +
                "childrenUIDs=" + childrenUIDs +
                '}';
    }
}
