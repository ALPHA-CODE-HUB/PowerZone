package com.example.powerzone.loginpages;

public class user {
    String uid;
    public String e_mail;
    public  String phonenumber;
    public String gender1;

    public user(String uid, String e_mail, String phonenumber, String gender1) {
        this.uid = uid;
        this.e_mail = e_mail;
        this.phonenumber = phonenumber;
        this.gender1 = gender1;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }
}
