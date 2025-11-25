package com.kr.grade.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;

@Getter
@SuperBuilder
@ToString(callSuper=true)
@Entity(name = "subject")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class SubjectEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 아이디 (PK, 기본키)


    @Column(name = "category")
    private Integer category; // 카테고리 (0: LCK, 1: 자동차, 2: IT, 3 : 서울 부동산)


    @Column(name = "name", length = 32)
    private String name; // 이름


    @Column(name = "img", length = 32)
    private String img; // 이미지경로
}
