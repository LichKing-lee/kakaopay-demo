package com.kakaopay.kakaopaydemo.user;

import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void transfer(Long senderId, Long receiverId, Money money) {
        var sender = userRepository.findById(senderId).orElseThrow();
        var receiver = userRepository.findById(receiverId).orElseThrow();

        sender.transferMoney(receiver, money);
    }
}
