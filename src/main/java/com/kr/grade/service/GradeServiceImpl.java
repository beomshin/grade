package com.kr.grade.service;

import com.kr.grade.constants.Category;
import com.kr.grade.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    @Override
    public List<CategoryDto> getCategory() {
        return List.of(
                new CategoryDto(Category.LCK),
                new CategoryDto(Category.IT),
                new CategoryDto(Category.CAR),
                new CategoryDto(Category.REAL_ESTATE)
        );
    }

    @Override
    public Integer getSubjectCount() {
        return 0;
    }

}

