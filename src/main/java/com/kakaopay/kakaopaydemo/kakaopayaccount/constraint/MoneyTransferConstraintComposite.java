package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;

import java.util.Arrays;
import java.util.Collection;

public class MoneyTransferConstraintComposite implements MoneyTransferConstraint {
    private Collection<MoneyTransferConstraint> constraints;

    public MoneyTransferConstraintComposite(MoneyTransferConstraint... constraints) {
        this.constraints = Arrays.asList(constraints);
    }

    @Override
    public boolean isSatisfy(KakaopayAccount sender, KakaopayAccount receiver, Money money) {
        return this.constraints.stream().anyMatch(constraint -> constraint.isSatisfy(sender, receiver, money));
    }
}
