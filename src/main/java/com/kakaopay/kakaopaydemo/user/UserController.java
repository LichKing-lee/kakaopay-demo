package com.kakaopay.kakaopaydemo.user;

import com.kakaopay.kakaopaydemo.kakaopayaccount.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/users/{userId}/accounts/transfer")
    void transferMoney(@PathVariable("userId") Long senderId, @RequestBody TransferMoneyRequest request) {
        userService.transfer(senderId, request.getReceiverId(), new Money(request.getMoney()));
    }
}
