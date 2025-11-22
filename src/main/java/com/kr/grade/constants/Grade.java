package com.kr.grade.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {

    S("s"),
    A("a"),
    B("b"),
    C("c"),
    D("d"),
    F("f")
    ;

    private final String value;
}
