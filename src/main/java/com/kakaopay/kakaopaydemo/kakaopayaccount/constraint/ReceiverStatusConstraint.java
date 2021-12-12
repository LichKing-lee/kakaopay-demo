package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;

public class ReceiverStatusConstraint implements MoneyTransferConstraint {
    @Override
    public boolean isSatisfy(KakaopayAccount sender, KakaopayAccount receiver, Money money) {
        return receiver.isDormancy();
    }
}
