package com.example.play_ground.java.enumPrac;

import java.util.function.Function;

public enum SalesAmount {
    ORIGINAL_PRICE("원래 금액", x -> x),
    DISCOUNT_PRICE("할인 금액", x -> Math.round(x.doubleValue() * 10 / 11));

    private final String priceType;
    private final Function<Long, Long> expression;

    SalesAmount(String priceType, Function<Long, Long> expression) { // 생성자 매서드
        this.priceType = priceType;
        this.expression = expression;
    }

    private String getPriceType(){
        return priceType;
    }


    public long calculate(long price){
        return expression.apply(price);
        // apply 함수는 @FunctionalInterface 어노테이션이 달려있는 Function 이하 녀석들에서 사용됨
    }
}
