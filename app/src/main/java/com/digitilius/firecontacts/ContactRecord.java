package com.digitilius.firecontacts;

public class ContactRecord {
    private String name;
    private String phone;

    public ContactRecord(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Constructor required for Firebase Database
    public ContactRecord() {
           }

    public String getContName() {
        return name;
    }

    public void setContName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
