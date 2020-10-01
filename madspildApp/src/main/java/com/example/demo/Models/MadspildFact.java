package com.example.demo.Models;

public class MadspildFact {
    public int foodKg;
    public int price;
    public int wastePerWeek;

    public MadspildFact(int foodKg, int price, int wastePerWeek){
        this.foodKg         = foodKg;
        this.price          = price;
        this.wastePerWeek   = wastePerWeek;
    }
    public int getFoodKg(){
        return foodKg;
    }
    public int getPrice(){
        return price;
    }
    public int getWastePerWeek(){
        return wastePerWeek;
    }
}
