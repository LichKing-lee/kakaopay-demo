package com.kakaopay.kakaopaydemo.kakaopayaccount;

import com.kakaopay.kakaopaydemo.kakaopayaccount.constraint.*;
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
    private KakaopayAccountStatus status = KakaopayAccountStatus.NORMAL;;

    @Transient
    private MoneyTransferConstraint constraint = new MoneyTransferConstraintComposite(
            new SenderBalanceConstraint(), new LimitedMoneyConstraint(), new ReceiverStatusConstraint()
    );;

    public KakaopayAccount(Money money) {
        this.balance = money;
    }

    public void transferTo(KakaopayAccount receiver, Money money) {
        if(this.constraint.isSatisfy(this, receiver, money)) {
            throw new MoneyTransferConstraintException();
        }

        this.balance = this.balance.minus(money);
        receiver.receive(money);
    }

    private void receive(Money money) {
        this.balance = this.balance.plus(money);
    }

    public boolean isDormancy() {
        return this.status == KakaopayAccountStatus.DORMANCY;
    }

    public void beDormancy() {
        this.status = KakaopayAccountStatus.DORMANCY;
    }
}
