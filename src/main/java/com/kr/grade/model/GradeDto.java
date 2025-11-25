package com.kr.grade.model;

import com.kr.grade.constants.Grade;
import com.kr.grade.persistence.entity.StatisticsEntity;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@ToString
public class GradeDto {

    private String grade;
    private List<ItemDto> items;


    public GradeDto(Grade grade, List<StatisticsEntity> statistics) {
        this.grade = grade.getValue();
        this.items = statistics.stream().map(it ->  new ItemDto(it.getName(), it.getImg())).toList();
    }

}
