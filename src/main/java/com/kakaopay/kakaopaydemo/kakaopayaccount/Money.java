package com.kakaopay.kakaopaydemo.kakaopayaccount;

import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Money {
    private final long value;

    long getValue() {
        return value;
    }

    public Money plus(Money money) {
        return new Money(this.value + money.value);
    }

    public Money minus(Money money) {
        return new Money(this.value - money.value);
    }

    public boolean isLessThan(Money money) {
        return value < money.value;
    }
}
