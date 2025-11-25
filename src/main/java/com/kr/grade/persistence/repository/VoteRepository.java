package com.kr.grade.persistence.repository;

import com.kr.grade.persistence.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
}
