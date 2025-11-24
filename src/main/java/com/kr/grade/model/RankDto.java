package com.kr.grade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@ToString
@AllArgsConstructor
public class RankDto {

    private Integer category;
    private String name;
    private String grade;

}
