package com.kakaopay.kakaopaydemo.user;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "kakaopay_account_id")
    private KakaopayAccount kakaopayAccount;

    public User(KakaopayAccount kakaopayAccount) {
        this.kakaopayAccount = kakaopayAccount;
    }

    public void transferMoney(User receiver, Money money) {
        this.kakaopayAccount.transferTo(receiver.kakaopayAccount, money);
    }
}
