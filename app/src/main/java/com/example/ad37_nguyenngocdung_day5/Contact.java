package com.example.ad37_nguyenngocdung_day5;

public class Contact {
    String name;
    String phone;
    String country;
    String date;
    String img;

    public Contact(String phone, String country, String date, String img, String name) {
        this.phone = phone;
        this.country = country;
        this.date = date;
        this.img = img;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
