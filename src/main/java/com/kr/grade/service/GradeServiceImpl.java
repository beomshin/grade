package com.kr.grade.service;

import com.kr.grade.constants.Category;
import com.kr.grade.model.CategoryDto;
import com.kr.grade.model.request.VoteRequest;
import com.kr.grade.persistence.entity.VoteEntity;
import com.kr.grade.persistence.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final VoteRepository voteRepository;

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

    @Override
    public boolean vote(VoteRequest request) {
        try {
            List<VoteEntity> votes = request.getRanks().stream()
                    .map(it -> VoteEntity
                            .builder()
                            .name(it.getName())
                            .category(it.getCategory())
                            .grade(it.getGrade())
                            .build())
                    .collect(Collectors.toUnmodifiableList());

            log.info("◆ 투표하기 저장");
            voteRepository.saveAll(votes);

            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

}

