package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import com.kakaopay.kakaopaydemo.kakaopayaccount.constraint.SenderBalanceConstraint;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SenderBalanceConstraintTest {
    @Test
    void 잔액보다_큰금액을_송금할수없다() {
        // given
        var sender = new KakaopayAccount(new Money(1000));
        var receiver = new KakaopayAccount(new Money(500));
        var constraint = new SenderBalanceConstraint();

        // when
        boolean satisfy = constraint.isSatisfy(sender, receiver, new Money(1500));

        // then
        assertThat(satisfy).isTrue();
    }
}