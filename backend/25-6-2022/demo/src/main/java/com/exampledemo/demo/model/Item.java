package com.exampledemo.demo.model;

public class Item {
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public Item(String id, String name, String pic, float price) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.price = price;
    }
    public Item(){};
    private String id;
    private String name;
    private String pic;
    private float price;
}
