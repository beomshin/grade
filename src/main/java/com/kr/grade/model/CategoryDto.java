package com.kr.grade.model;

import com.kr.grade.constants.Category;
import com.kr.grade.constants.Grade;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@ToString
public class CategoryDto {

    private String name;
    private List<GradeDto> grades;

    public CategoryDto(Category category) {

        this.name = category.getValue();
        this.grades = List.of(
                new GradeDto(category, Grade.S),
                new GradeDto(category, Grade.A),
                new GradeDto(category, Grade.B),
                new GradeDto(category, Grade.C),
                new GradeDto(category, Grade.D),
                new GradeDto(category, Grade.F)
        );

    }

}
