package com.kakaopay.kakaopaydemo.kakaopayaccount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class KakaopayAccountTest {
    @Test
    void 송금하면_잔액이_변경된다() {
        // given
        var sender = new KakaopayAccount(new Money(1000));
        var receiver = new KakaopayAccount(new Money(500));

        // when
        sender.transfer(receiver, new Money(700));

        // then
        assertThat(sender.getBalance()).isEqualTo(new Money(300));
        assertThat(receiver.getBalance()).isEqualTo(new Money(1200));
    }

    @Test
    void 잔액보다_큰금액을_송금할수없다() {
        // given
        var sender = new KakaopayAccount(new Money(1000));
        var receiver = new KakaopayAccount(new Money(500));

        // when then
        assertThatThrownBy(() -> sender.transfer(receiver, new Money(1200)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 만원보다_큰금액을_송금할수없다() {
        // given
        var sender = new KakaopayAccount(new Money(20000));
        var receiver = new KakaopayAccount(new Money(500));

        // when then
        assertThatThrownBy(() -> sender.transfer(receiver, new Money(10001)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 휴면계좌에_송금할수없다() {
        // given
        var sender = new KakaopayAccount(new Money(20000));
        var receiver = new KakaopayAccount(new Money(500));
        receiver.beDormancy();

        // when then
        assertThatThrownBy(() -> sender.transfer(receiver, new Money(10000)))
                .isExactlyInstanceOf(IllegalStateException.class);
    }
}