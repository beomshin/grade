package com.kr.grade.model;

import com.kr.grade.constants.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@ToString
@AllArgsConstructor
public class RankDto {

    private Long id;
    private Integer category;
    private String name;
    private String grade;

    public Integer getScore() {

        switch (Grade.getGrade(grade.toLowerCase())) {
            case S -> {
                return 5;
            }
            case A -> {
                return 4;
            }
            case B -> {
                return 3;
            }
            case C -> {
                return 2;
            }
            case D -> {
                return 1;
            }
            case F -> {
                return 0;
            }
            case null -> {
                return 0;
            }
            case RANK_1 -> {
                return 5;
            }
            case RANK_2 -> {
                return 4;
            }
            case RANK_3 -> {
                return 3;
            }
            case RANK_4 -> {
                return 2;
            }
            case RANK_5 -> {
                return 1;
            }
            case RANK_6 -> {
                return 0;
            }
        }
    }

}
