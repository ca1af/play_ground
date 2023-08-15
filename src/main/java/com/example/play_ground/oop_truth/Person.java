package com.example.play_ground.oop_truth;

public class Person {
    // 상태들
    private Integer height;

    private String location;

    public Person(Integer height, String location) {
        this.height = height;
        this.location = location;
    }

    // 행위
    public Integer getHeight() {
        return height;
    }

    public String getLocation() {
        return location;
    }

    public int drinkBeverage(Beverage beverage){
        this.height -= 20; // 임의상 20씩 작아진다고 가정
        return beverage.getQuantity() - 20; // 남은 양 알려줄게!

    }

    public void passByDoor(boolean isPassable){
        if (isPassable) {
            this.location = "새로운 어딘가";
        } else {
            System.out.println("이곳엔 들어갈 수 없다.");
        }
    }
}
