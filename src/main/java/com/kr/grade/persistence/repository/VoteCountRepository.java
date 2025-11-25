package com.kr.grade.persistence.repository;

import com.kr.grade.persistence.entity.VoteCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface VoteCountRepository extends JpaRepository<VoteCountEntity, Long> {

    long countByRegDtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
