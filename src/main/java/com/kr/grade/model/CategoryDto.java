package com.kr.grade.model;

import com.kr.grade.constants.Category;
import com.kr.grade.constants.Grade;
import com.kr.grade.persistence.entity.StatisticsEntity;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Getter
@ToString
public class CategoryDto {

    private String name;
    private List<GradeDto> grades;


    public CategoryDto(Category category, List<StatisticsEntity> list) {
        this.name = category.getValue();
        List<StatisticsEntity> data = list.stream().sorted(((o1, o2) -> o2.getScore() - o1.getScore())).toList();


        switch (category) {

            case LCK -> {
                this.grades = List.of(
                        new GradeDto(Grade.S, data.subList(0, 8)),
                        new GradeDto(Grade.A, data.subList(8, 15)),
                        new GradeDto(Grade.B, data.subList(15, 24)),
                        new GradeDto(Grade.C, data.subList(24, 36)),
                        new GradeDto(Grade.D, data.subList(36, 48)),
                        new GradeDto(Grade.F, data.subList(48, data.size()))
                );
            }

            case CAR -> {
                this.grades = List.of(
                        new GradeDto(Grade.S, data.subList(0, 3)),
                        new GradeDto(Grade.A, data.subList(3, 7)),
                        new GradeDto(Grade.B, data.subList(7, 12)),
                        new GradeDto(Grade.C, data.subList(12, 16)),
                        new GradeDto(Grade.D, data.subList(16, 25)),
                        new GradeDto(Grade.F, data.subList(25, data.size()))
                );
            }

            case IT -> {
                this.grades = List.of(
                        new GradeDto(Grade.S, data.subList(0, 5)),
                        new GradeDto(Grade.A, data.subList(5, 8)),
                        new GradeDto(Grade.B, data.subList(8, 13)),
                        new GradeDto(Grade.C, data.subList(13, 17)),
                        new GradeDto(Grade.D, data.subList(17, 22)),
                        new GradeDto(Grade.F, data.subList(22, data.size()))
                );
            }

            case REAL_ESTATE -> {
                this.grades = List.of(
                        new GradeDto(Grade.S, data.subList(0, 2)),
                        new GradeDto(Grade.A, data.subList(2, 4)),
                        new GradeDto(Grade.B, data.subList(4, 8)),
                        new GradeDto(Grade.C, data.subList(8, 13)),
                        new GradeDto(Grade.D, data.subList(13, 19)),
                        new GradeDto(Grade.F, data.subList(19, data.size()))
                );
            }

        }

    }

}
