package com.kakaopay.kakaopaydemo.kakaopayaccount;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
    @Test
    void 더해진_금액을_반환한다() {
        // given
        var money = new Money(500);
        var target = new Money(1000);

        // when
        var actual = money.plus(target);

        // then
        assertThat(actual).isEqualTo(new Money(1500));
    }

    @Test
    void 빼진_금액을_반환한다() {
        // given
        var money = new Money(1000);
        var target = new Money(500);

        // when
        var actual = money.minus(target);

        // then
        assertThat(actual).isEqualTo(new Money(500));
    }
}