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
    F("f"),


    RANK_1("1위"),
    RANK_2("2위"),
    RANK_3("3위"),
    RANK_4("4위"),
    RANK_5("5위"),
    RANK_6("RISE")
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
