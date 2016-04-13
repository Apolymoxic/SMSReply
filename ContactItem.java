package com.example.apolymoxic.smsreply;

public class ContactItem {

    Integer idVal;
    String contact, message;

    public ContactItem(Integer i, String c, String m) {
        this.idVal = i;
        this.contact = c;
        this.message = m;
    }

    // getters
    public Integer getId() { return idVal; }
    public String getContact() { return contact; }
    public String getMessage() {
        return message;
    }

    // setters
    public void setId(Integer i) { idVal = i; }
    public void setContact(String c) {
        contact = c;
    }
    public void setMessage(String m) {
        message = m;
    }
}