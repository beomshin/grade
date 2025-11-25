package com.kr.grade.service;

import com.kr.grade.model.CategoryDto;
import com.kr.grade.model.request.VoteRequest;

import java.util.List;

public interface GradeService {

    List<CategoryDto> getCategory();

    Integer getSubjectCount();

    boolean vote(VoteRequest request);
}
