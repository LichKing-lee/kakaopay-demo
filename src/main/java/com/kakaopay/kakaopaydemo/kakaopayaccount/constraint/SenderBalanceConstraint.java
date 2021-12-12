package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;

public class SenderBalanceConstraint implements MoneyTransferConstraint {
    @Override
    public boolean isSatisfy(KakaopayAccount sender, KakaopayAccount receiver, Money money) {
        return sender.getBalance().isLessThan(money);
    }
}
