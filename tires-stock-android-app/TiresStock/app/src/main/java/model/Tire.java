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
    private String quantity;
    @Expose
    private String price;
    private final int NUMBER_OF_COLUMNS = 7;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getNUMBER_OF_COLUMNS() {
        return NUMBER_OF_COLUMNS;
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
