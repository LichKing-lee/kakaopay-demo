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
    private Money balance;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private KakaopayAccountStatus status;

    public KakaopayAccount(Money money) {
        this.balance = money;
        this.status = KakaopayAccountStatus.NORMAL;
    }

    public void transfer(KakaopayAccount receiver, Money money) {
        if(this.balance.isLessThan(money)) {
            throw new IllegalArgumentException();
        }

        if(!money.isLessThan(new Money(10001))) {
            throw new IllegalArgumentException();
        }

        if(receiver.isDormancy()) {
            throw new IllegalStateException();
        }

        this.balance = this.balance.minus(money);
        receiver.receive(money);
    }

    private void receive(Money money) {
        this.balance = this.balance.plus(money);
    }

    private boolean isDormancy() {
        return this.status == KakaopayAccountStatus.DORMANCY;
    }

    public void beDormancy() {
        this.status = KakaopayAccountStatus.DORMANCY;
    }
}
