package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import com.kakaopay.kakaopaydemo.kakaopayaccount.constraint.ReceiverStatusConstraint;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReceiverStatusConstraintTest {
    @Test
    void 휴면계좌에_송금할수없다() {
        // given
        var sender = new KakaopayAccount(new Money(20000));
        var receiver = new KakaopayAccount(new Money(500));
        receiver.beDormancy();
        var constraint = new ReceiverStatusConstraint();

        // when
        boolean satisfy = constraint.isSatisfy(sender, receiver, new Money(10100));

        // then
        assertThat(satisfy).isTrue();
    }
}