package com.example.plateful;

public class DescriptionOfDish {
    private String necessaryTime, calorieCount, proteinCount, amountOfFat, carbohydrateCount,
    necessaryIngredients, kitchenType, commonAllergen;
    public DescriptionOfDish(String necessaryTime, String calorieCount, String proteinCount,
                             String amountOfFat, String carbohydrateCount, String necessaryIngredients,
                             String kitchenType, String commonAllergen) {
        this.necessaryTime = necessaryTime;
        this.calorieCount = calorieCount;
        this.proteinCount = proteinCount;
        this.amountOfFat = amountOfFat;
        this.carbohydrateCount = carbohydrateCount;
        this.necessaryIngredients = necessaryIngredients;
        this.kitchenType = kitchenType;
        this.commonAllergen = commonAllergen;
    }
    public String getNecessaryTime() {
        return this.necessaryTime;
    }
    public void setNecessaryTime(String necessaryTime) {
        this.necessaryTime = necessaryTime;
    }
    public String getCalorieCount() {
        return this.calorieCount;
    }
    public void setCalorieCount(String calorieCount) {
        this.calorieCount = calorieCount;
    }
    public String getProteinCount() {
        return this.proteinCount;
    }
    public void setProteinCount(String proteinCount) {
        this.proteinCount = proteinCount;
    }
    public String getAmountOfFat() {
        return this.amountOfFat;
    }
    public void setAmountOfFat(String amountOfFat) {
        this.amountOfFat = amountOfFat;
    }
    public String getCarbohydrateCount() {
        return this.carbohydrateCount;
    }
    public void setCarbohydrateCount(String carbohydrateCount) {
        this.carbohydrateCount = carbohydrateCount;
    }
    public String getNecessaryIngredients() {
        return this.necessaryIngredients;
    }
    public void setNecessaryIngredients(String necessaryIngredients) {
        this.necessaryIngredients = necessaryIngredients;
    }
    public String getKitchenType() {
        return this.kitchenType;
    }
    public void setKitchenType(String kitchenType) {
        this.kitchenType = kitchenType;
    }
    public String getCommonAllergen() {
        return this.commonAllergen;
    }
    public void setCommonAllergen(String commonAllergen) {
        this.commonAllergen = commonAllergen;
    }
}
