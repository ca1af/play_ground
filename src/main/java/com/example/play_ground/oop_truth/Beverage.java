package com.example.play_ground.oop_truth;

public class Beverage {
    private Integer quantity;

    public Beverage(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void adjustQuantity(Integer drunken){
        this.quantity = drunken;
    }
}
