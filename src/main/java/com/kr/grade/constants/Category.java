package com.kr.grade.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    LCK_2026_RANK("2026 LCK 순위"),
    LCK_PERSON("2026 LCK 선수"),
    CAR("자동차 브랜드"),
    IT("IT 기업"),
    REAL_ESTATE("서울 부동산")
    ;

    private final String value;

}
