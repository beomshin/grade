package com.kr.grade.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

@Getter
@SuperBuilder
@ToString(callSuper=true)
@Entity(name = "statistics")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class StatisticsEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 아이디 (PK, 기본키)


    @Column(name = "category")
    private Integer category; // 카테고리 (0: LCK, 1: 자동차, 2: IT, 3 : 서울 부동산)

    @Column(name = "round")
    private Integer round;

    @Column(name = "name", length = 32)
    private String name; // 이름


    @Column(name = "img", length = 32)
    private String img; // 이미지경로

    @Column(name = "score")
    private Integer score;

    @Column(name = "s_cnt")
    private Integer s_cnt;

    @Column(name = "a_cnt")
    private Integer a_cnt;

    @Column(name = "b_cnt")
    private Integer b_cnt;

    @Column(name = "c_cnt")
    private Integer c_cnt;

    @Column(name = "d_cnt")
    private Integer d_cnt;

    @Column(name = "f_cnt")
    private Integer f_cnt;

}
