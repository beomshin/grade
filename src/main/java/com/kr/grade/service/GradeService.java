package com.kr.grade.service;

import com.kr.grade.model.CategoryDto;
import com.kr.grade.model.request.VoteRequest;
import com.kr.grade.persistence.entity.SubjectEntity;

import java.util.List;

public interface GradeService {

    List<CategoryDto> getCategory();

    List<SubjectEntity> getSubject();

    Long getSubjectCount();

    boolean vote(VoteRequest request);
}
