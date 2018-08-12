package com.example.database;

public class Contact {

    private String contactName;
    private String contactNumb;

    public Contact(String contactName, String contactNumb) {

        this.contactName = contactName;
        this.contactNumb = contactNumb;
    }

    public String getContactName() {

        return contactName;
    }

    public String getContactNumb() {

        return contactNumb;
    }
}
