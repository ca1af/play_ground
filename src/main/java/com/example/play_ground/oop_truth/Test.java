package com.example.play_ground.oop_truth;

public class Test {
    public static void main(String[] args) {
        Person alice = new Person(130, "처음 시작한 곳"); // 앨리스는 키가 130cm 인 사람의 인스턴스 객체이다.
        Door door = new Door(100); // 앨리스가 여행 중 만난 문. 100cm 의 키를 가진 인스턴스이다.
        Beverage beverage = new Beverage(200); // 200의 양을 가지는 음료 인스턴스

        System.out.println("1. 앨리스가 door 에게 통과해도 되냐고 물어본다. 이를 위해 앨리스는 자신의 키(상태) 를 문에게 공개해야 한다.");
        Integer aliceHeight = alice.getHeight();
        System.out.println("현재 시점의 앨리스의 키는 : " + aliceHeight + " 이다.");


        System.out.println("2. 도어는 앨리스의 키를 전달받고, 지나갈 수 있는지 판별한다.");
        boolean canPass = door.isPassable(aliceHeight);
        System.out.println("판별 결과, : " + canPass);

        System.out.println("3. 도어는 키가 100 이하만 들어올 수 있다고 답변하고, 앨리스는 이 답변을 확인한다.");
        alice.passByDoor(canPass);

        System.out.println("4. 앨리스는 자신의 상태가 들어갈 수 없는 상태임을 알았으므로,통과 될 때까지 키가 작아지는 음료를 마신다.");
        System.out.println("음료의 처음 양은 : " + beverage.getQuantity());
        while (alice.getHeight() > 100 ) {
            int quantityOfDrunkenBeverage = alice.drinkBeverage(beverage);
            beverage.adjustQuantity(quantityOfDrunkenBeverage);
        }

        System.out.println("5. 앨리스는 음료를 마실때마다 음료의 상태를 음료에게 알려줬고, 음료는 이를 통해서 자신의 양을 조절했다.");
        System.out.println("음료의 나중의 양은 : " + beverage.getQuantity());

        System.out.println("6. 앨리스가 문에게 다시 물어보고, 문은 자신을 열어준다");
        alice.passByDoor(door.isPassable(alice.getHeight()));

        System.out.println("7. 앨리스는 문을 지나 새로운곳으로 왔다. 장소는 : " + alice.getLocation());
    }
}
