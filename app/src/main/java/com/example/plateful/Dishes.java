package com.example.plateful;

public class Dishes {
    private String nameOfDish;
    private String descriptionOfDish;
    private int dishImgResource;
    public Dishes (String nameOfDish, String descriptionOfDish, int dishImgResource) {
        this.nameOfDish = nameOfDish;
        this.descriptionOfDish = descriptionOfDish;
        this.dishImgResource = dishImgResource;
    }
    public String getNameOfDish() {
        return this.nameOfDish;
    }
    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }
    public String getDescriptionOfDish() {
        return this.descriptionOfDish;
    }
    public void setDescriptionOfDish(String descriptionOfDish) {
        this.descriptionOfDish = descriptionOfDish;
    }
    public int getDishImgResource() {
        return this.dishImgResource;
    }
    public void setDishImgResource(int dishImgResource) {
        this.dishImgResource = dishImgResource;
    }
}
