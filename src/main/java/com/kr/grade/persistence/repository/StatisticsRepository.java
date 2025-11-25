package com.kr.grade.persistence.repository;

import com.kr.grade.persistence.entity.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StatisticsRepository extends JpaRepository<StatisticsEntity, Long> {


    @Modifying
    @Query("UPDATE statistics s SET s.score = s.score + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseScore(@Param("category") Integer category,
                      @Param("name") String name,
                      @Param("value") Integer value,
                      @Param("round") Integer round);


    @Modifying
    @Query("UPDATE statistics s SET s.s_cnt = s.s_cnt + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseScnt(@Param("category") Integer category,
                      @Param("name") String name,
                      @Param("value") Integer value,
                     @Param("round") Integer round);


    @Modifying
    @Query("UPDATE statistics s SET s.a_cnt = s.a_cnt + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseAcnt(@Param("category") Integer category,
                     @Param("name") String name,
                     @Param("value") Integer value,
                     @Param("round") Integer round);

    @Modifying
    @Query("UPDATE statistics s SET s.b_cnt = s.b_cnt + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseBcnt(@Param("category") Integer category,
                     @Param("name") String name,
                     @Param("value") Integer value,
                     @Param("round") Integer round);

    @Modifying
    @Query("UPDATE statistics s SET s.c_cnt = s.c_cnt + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseCcnt(@Param("category") Integer category,
                     @Param("name") String name,
                     @Param("value") Integer value,
                     @Param("round") Integer round);

    @Modifying
    @Query("UPDATE statistics s SET s.d_cnt = s.d_cnt + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseDcnt(@Param("category") Integer category,
                     @Param("name") String name,
                     @Param("value") Integer value,
                     @Param("round") Integer round);

    @Modifying
    @Query("UPDATE statistics s SET s.f_cnt = s.f_cnt + :value " +
            "WHERE s.category = :category AND s.name = :name AND s.round = :round")
    int increaseFcnt(@Param("category") Integer category,
                     @Param("name") String name,
                     @Param("value") Integer value,
                     @Param("round") Integer round);
}
