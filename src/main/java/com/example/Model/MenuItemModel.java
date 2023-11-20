package com.example.Model;

import com.opencsv.bean.CsvBindByName;

public class MenuItemModel {
    @CsvBindByName(column =  "id")
    private Integer id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "price")
    private double price;

    @CsvBindByName(column = "image")
    private String image;

    public MenuItemModel(){
        super();
    }

    public MenuItemModel(String name, String description, double price, String image){
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}
