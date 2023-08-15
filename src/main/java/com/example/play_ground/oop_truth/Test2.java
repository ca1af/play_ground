package com.example.play_ground.oop_truth;

public class Test2 {
    public static void main(String[] args) {
        // 앨리스, 도어, 음료 객체 생성
        Person alice = new Person(130, "처음 시작한 곳");
        Door door = new Door(100);
        Beverage beverage = new Beverage(200);

        // 앨리스의 키 확인
        int aliceHeight = alice.getHeight();
        System.out.println("앨리스의 키: " + aliceHeight);

        // 도어 판별
        boolean canPass = door.isPassable(aliceHeight);
        System.out.println("앨리스가 통과 가능한가? " + canPass);

        // 도어 통과 여부에 따라 처리
        alice.passByDoor(canPass);

        // 음료 마시며 키 조절
        System.out.println("음료의 처음 양: " + beverage.getQuantity());
        while (alice.getHeight() > 100) {
            int quantityOfDrunkenBeverage = alice.drinkBeverage(beverage);
            beverage.adjustQuantity(quantityOfDrunkenBeverage);
        }
        System.out.println("음료의 최종 양: " + beverage.getQuantity());
        System.out.println("앨리스의 최종 키: " + alice.getHeight());

        // 문 통과
        alice.passByDoor(door.isPassable(alice.getHeight()));

        // 결과 출력
        System.out.println("앨리스의 현재 위치: " + alice.getLocation());
    }
}
