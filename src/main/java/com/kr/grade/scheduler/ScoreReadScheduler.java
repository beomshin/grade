package com.kr.grade.scheduler;

import com.kr.grade.constants.Grade;
import com.kr.grade.persistence.entity.VoteEntity;
import com.kr.grade.persistence.repository.StatisticsRepository;
import com.kr.grade.persistence.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScoreReadScheduler {

    private final VoteRepository voteRepository;
    private final StatisticsRepository statisticsRepository;

    private final int round = 0;

    @Transactional
    @Scheduled(fixedDelay = 10000)
    public void readScore() {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = today.with(DayOfWeek.SATURDAY);

        LocalDateTime start = startOfWeek.atStartOfDay();
        LocalDateTime end = endOfWeek.plusDays(1).atStartOfDay();

        List<VoteEntity> voteEntities = voteRepository.findByReadFlagAndRegDtBetween(0, start, end);

        for (VoteEntity voteEntity : voteEntities) {

            statisticsRepository.increaseScore(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);

            switch (Grade.getGrade(voteEntity.getGrade().toLowerCase())) {

                case S, RANK_1 -> {
                    statisticsRepository.increaseScnt(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);
                }

                case A, RANK_2 -> {
                    statisticsRepository.increaseAcnt(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);
                }

                case B, RANK_3 -> {
                    statisticsRepository.increaseBcnt(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);
                }

                case C, RANK_4 -> {
                    statisticsRepository.increaseCcnt(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);
                }

                case D, RANK_5 -> {
                    statisticsRepository.increaseDcnt(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);
                }

                case F, RANK_6 -> {
                    statisticsRepository.increaseFcnt(voteEntity.getCategory(), voteEntity.getName(), voteEntity.getScore(), round);
                }

                case null -> {}
            }

        }

        voteRepository.deleteAll(voteEntities);

    }
}
