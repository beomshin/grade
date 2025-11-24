package com.kr.grade.model.request;

import com.kr.grade.model.RankDto;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Slf4j
@ToString
public class VoteRequest {

    private List<RankDto> ranks;

}
