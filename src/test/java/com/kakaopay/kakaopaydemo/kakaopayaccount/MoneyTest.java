package com.kakaopay.kakaopaydemo.kakaopayaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void 인자보다_작은금액이면_true() {
        // given
        var money = new Money(500);

        // when
        boolean actual = money.isLessThan(new Money(700));

        // then
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {500, 300})
    void 인자보다_작거나_같은금액이면_false(long value) {
        // given
        var money = new Money(500);

        // when
        boolean actual = money.isLessThan(new Money(value));

        // then
        assertThat(actual).isFalse();
    }
}