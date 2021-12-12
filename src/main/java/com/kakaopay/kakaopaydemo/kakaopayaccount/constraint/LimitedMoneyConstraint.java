package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import com.kakaopay.kakaopaydemo.kakaopayaccount.constraint.MoneyTransferConstraint;

public class LimitedMoneyConstraint implements MoneyTransferConstraint {
    private Money limit = new Money(10001);

    @Override
    public boolean isSatisfy(KakaopayAccount sender, KakaopayAccount receiver, Money money) {
        return !money.isLessThan(limit);
    }
}
