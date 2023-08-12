package com.example.play_ground.java.enumPrac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesAmountTest {
    @Test
    void enum_이_진짜로_잘되나요(){
        //given
        long val = 10000L;

        //when
        long original = SalesAmount.ORIGINAL_PRICE.calculate(val);
        long discount = SalesAmount.DISCOUNT_PRICE.calculate(val);

        //then
        assertEquals(original, 10000L);
        assertEquals(discount, 9091L); // 10/11 로 나눈 값
    }

    @Test
    void enum_은_슈퍼_enum_인가요(){
        //given
        PaymentType cash1 = PaymentType.CASH;
        PaymentType tossPay = PaymentType.TOSS_PAY;

        //then
        PaymentGroup foundByCash = PaymentGroup.findGroup(cash1);
        PaymentGroup foundByToss = PaymentGroup.findGroup(tossPay);

        PaymentGroup cash = PaymentGroup.CASH;
        PaymentGroup pg = PaymentGroup.PG;

        assertEquals(foundByToss, pg);
        assertEquals(foundByCash, cash);
    }
}