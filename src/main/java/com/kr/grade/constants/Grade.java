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

    public static Grade getGrade(final String value) {
        for (Grade grade : Grade.values()) {
            if (grade.getValue().equals(value)) {
                return grade;
            }
        }
        return null;
    }
}
