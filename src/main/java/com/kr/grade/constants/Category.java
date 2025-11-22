package com.kr.grade.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    LCK("2025 LCK"),
    CAR("자동차 브랜드"),
    IT("IT 기업"),
    REAL_ESTATE("서울 부동산")
    ;

    private final String value;

}
