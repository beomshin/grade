package com.kr.grade.service;

import com.kr.grade.constants.Category;
import com.kr.grade.model.CategoryDto;
import com.kr.grade.model.request.VoteRequest;
import com.kr.grade.persistence.entity.StatisticsEntity;
import com.kr.grade.persistence.entity.SubjectEntity;
import com.kr.grade.persistence.entity.VoteCountEntity;
import com.kr.grade.persistence.entity.VoteEntity;
import com.kr.grade.persistence.repository.StatisticsRepository;
import com.kr.grade.persistence.repository.SubjectRepository;
import com.kr.grade.persistence.repository.VoteCountRepository;
import com.kr.grade.persistence.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final VoteRepository voteRepository;
    private final VoteCountRepository voteCountRepository;
    private final SubjectRepository subjectRepository;
    private final StatisticsRepository statisticsRepository;

    @Override
    public List<CategoryDto> getCategory() {
        List<StatisticsEntity> list = statisticsRepository.findByRound(0);

        return List.of(
                new CategoryDto(Category.LCK, list.stream().filter(it -> it.getCategory() == 0).toList()),
                new CategoryDto(Category.CAR, list.stream().filter(it -> it.getCategory() == 1).toList()),
                new CategoryDto(Category.IT, list.stream().filter(it -> it.getCategory() == 2).toList()),
                new CategoryDto(Category.REAL_ESTATE, list.stream().filter(it -> it.getCategory() == 3).toList())
        );
    }

    @Override
    public List<SubjectEntity> getSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Long getSubjectCount() {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = today.with(DayOfWeek.SATURDAY);

        LocalDateTime start = startOfWeek.atStartOfDay();
        LocalDateTime end = endOfWeek.plusDays(1).atStartOfDay();

        return voteCountRepository.countByRegDtBetween(start, end);
    }

    @Override
    @Transactional
    public boolean vote(VoteRequest request) {
        try {
            List<VoteEntity> votes = request.getRanks().stream()
                    .map(it -> VoteEntity
                            .builder()
                            .subjectEntity(SubjectEntity.builder()
                                    .id(it.getId())
                                    .build())
                            .name(it.getName())
                            .category(it.getCategory())
                            .grade(it.getGrade())
                            .score(it.getScore())
                            .build())
                    .collect(Collectors.toUnmodifiableList());

            String token = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            log.info("◆ 투표하기 저장 시작 : {}개 , token {}", votes.size(), token);
            voteRepository.saveAll(votes);
            voteCountRepository.save(VoteCountEntity.builder().token(token).build());

            log.info("◆ 투표하기 저장 종료");

            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

}

