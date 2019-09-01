package model;

import com.google.gson.annotations.Expose;

/**
 * Created by paul-ioan.barbu on 09.01.2016.
 */
public class Tire {
    private int id;
    @Expose
    private String brand;
    @Expose
    private String size;
    @Expose
    private String profile;
    @Expose
    private String speed_rating;
    @Expose
    private int quantity;
    @Expose
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSpeed_rating() {
        return speed_rating;
    }

    public void setSpeed_rating(String speed_rating) {
        this.speed_rating = speed_rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                '"' + "brand" + '"' + ":" + '"' + brand + '"' +
                "," + '"' + "size" + '"' + ":" + '"' + size + '"' +
                "," + '"' + "profile" + '"' + ":" + '"' + profile + '"' +
                "," + '"' + "speed_rating" + '"' + ":" + '"' + speed_rating + '"' +
                "," + '"' + "quantity" + '"' + ":" + '"' + quantity + '"' +
                "," + '"' + "price" + '"' + ":" + '"' + price + '"' +
                "}";
    }
}
