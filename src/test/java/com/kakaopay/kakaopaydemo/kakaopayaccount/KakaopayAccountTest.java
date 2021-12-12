package com.kakaopay.kakaopaydemo.kakaopayaccount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
}