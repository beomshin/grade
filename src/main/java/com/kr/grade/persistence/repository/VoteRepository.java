package com.kr.grade.persistence.repository;

import com.kr.grade.persistence.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {

    List<VoteEntity> findByReadFlagAndRegDtBetween(Integer readFlag, LocalDateTime startDate, LocalDateTime endDate);
}
