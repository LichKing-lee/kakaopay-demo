package com.kakaopay.kakaopaydemo.user;

import lombok.Data;

@Data
public class TransferMoneyRequest {
    private Long receiverId;
    private Long money;
}
