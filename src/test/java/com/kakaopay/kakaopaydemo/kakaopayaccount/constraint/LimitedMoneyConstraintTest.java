package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import com.kakaopay.kakaopaydemo.kakaopayaccount.constraint.LimitedMoneyConstraint;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LimitedMoneyConstraintTest {
    @Test
    void 만원보다_큰금액을_송금할수없다() {
        // given
        var sender = new KakaopayAccount(new Money(20000));
        var receiver = new KakaopayAccount(new Money(500));
        var constraint = new LimitedMoneyConstraint();

        // when
        boolean satisfy = constraint.isSatisfy(sender, receiver, new Money(10001));

        // then
        assertThat(satisfy).isTrue();
    }
}