package com.example.play_ground.java.enumPrac;

import java.util.Arrays;

public enum PaymentGroup {
    CASH("현금", new PaymentType[]{
            PaymentType.CASH, PaymentType.BANK_TRANSFER
    }),
    PG("결제 대행사", new PaymentType[]{
            PaymentType.NAVER_PAY, PaymentType.KAKAO_PAY, PaymentType.TOSS_PAY
    });

    private final String name;

    private final PaymentType[] paymentTypes;

    PaymentGroup(String name, PaymentType[] paymentTypes) {
        this.name = name;
        this.paymentTypes = paymentTypes;
    }

    public static PaymentGroup findGroup(PaymentType paymentType){
        return Arrays.stream(PaymentGroup.values()) // 페이먼트 녀석들
                .filter(group -> isPaymentMatches(group, paymentType))
                .findFirst()
                .orElseThrow();
    }

    public static boolean isPaymentMatches(PaymentGroup group, PaymentType target){
        return Arrays.stream(group.paymentTypes)
                .anyMatch(any -> any == target);
    }
}
