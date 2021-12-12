package com.kakaopay.kakaopaydemo.user;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void save_test() {
        // given
        var kakaopayAccount = new KakaopayAccount(new Money(1000));
        var user = new User(kakaopayAccount);

        // when
        userRepository.save(user);

        entityManager.flush();
        entityManager.clear();

        // then
        assertThat(user.getId()).isNotNull();
    }
}