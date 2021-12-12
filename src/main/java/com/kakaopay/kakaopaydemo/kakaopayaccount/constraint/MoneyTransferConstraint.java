package com.kakaopay.kakaopaydemo.kakaopayaccount.constraint;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;

public interface MoneyTransferConstraint {
    boolean isSatisfy(KakaopayAccount sender, KakaopayAccount receiver, Money money);
}
