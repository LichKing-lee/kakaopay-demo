package com.kakaopay.kakaopaydemo.kakaopayaccount;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MoneyAttributeConverter implements AttributeConverter<Money, Long> {
    @Override
    public Long convertToDatabaseColumn(Money attribute) {
        return attribute.getValue();
    }

    @Override
    public Money convertToEntityAttribute(Long dbData) {
        return new Money(dbData);
    }
}
