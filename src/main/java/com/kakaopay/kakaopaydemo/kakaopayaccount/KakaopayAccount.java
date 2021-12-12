package com.kakaopay.kakaopaydemo.kakaopayaccount;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "kakaopay_account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
@Getter
public class KakaopayAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kakaopay_account_id")
    private Long id;

    @Column(name = "balance")
    private Money money;

    public KakaopayAccount(Money money) {
        this.money = money;
    }
}
