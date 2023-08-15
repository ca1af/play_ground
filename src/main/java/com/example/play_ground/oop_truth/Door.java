package com.example.play_ground.oop_truth;

public class Door {

    private Integer height;

    private boolean isOpen;

    public Door(Integer height) {
        this.height = height;
        this.isOpen = false; // 기본적으로 닫혀 있고, 키가 적절하면 열어주자
    }

    public boolean isPassable(Integer passengerHeight){
        return passengerHeight < height;
    }
}
