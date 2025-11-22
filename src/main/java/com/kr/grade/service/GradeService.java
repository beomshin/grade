package com.kr.grade.service;

import com.kr.grade.model.CategoryDto;

import java.util.List;

public interface GradeService {

    List<CategoryDto> getCategory();

    Integer getSubjectCount();
}
