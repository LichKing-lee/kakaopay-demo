package com.kakaopay.kakaopaydemo;

import com.kakaopay.kakaopaydemo.kakaopayaccount.KakaopayAccount;
import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import com.kakaopay.kakaopaydemo.user.User;
import com.kakaopay.kakaopaydemo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class KakaopayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaopayDemoApplication.class, args);
    }

}

@Component
@RequiredArgsConstructor
class Initializer implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        var user1 = new User(new KakaopayAccount(new Money(5000)));
        var user2 = new User(new KakaopayAccount(new Money(5000)));

        userRepository.saveAll(List.of(user1, user2));
    }
}