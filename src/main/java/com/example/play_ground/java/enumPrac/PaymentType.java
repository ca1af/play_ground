package com.example.play_ground.java.enumPrac;

public enum PaymentType {
    CASH("현금"),
    BANK_TRANSFER("계좌이체"),
    KAKAO_PAY("카카오 페이"),
    NAVER_PAY("네이버 페이"),
    TOSS_PAY("토스 페이");

    PaymentType(String name) { // 생성자 매서드
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}
