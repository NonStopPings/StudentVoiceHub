package com.demin.studentvoicehub05;

public class ImageUploadInfo_BuyAndSell {
    String title;
    String description;
    String email;
    String price;
    String campus;
    String image;
    String search;

    public ImageUploadInfo_BuyAndSell() {
    }

    public ImageUploadInfo_BuyAndSell(String title, String description, String email, String price, String campus, String image, String search) {
        this.title = title;
        this.description = description;
        this.email = email;
        this.price = price;
        this.campus = campus;
        this.image = image;
        this.search = search;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPrice() {
        return price;
    }

    public String getCampus() {
        return campus;
    }

    public String getImage() {
        return image;
    }

    public String getSearch() {
        return search;
    }
}

