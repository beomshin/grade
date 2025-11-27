package com.kr.grade.controller;

import com.kr.grade.model.request.VoteRequest;
import com.kr.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        log.info("◆ 메인 페이지 이동");
        mav.addObject("categories", gradeService.getCategory());
        mav.addObject("subjectCount", gradeService.getSubjectCount());
        mav.addObject("tier", Arrays.asList("s", "a", "b", "c", "d", "f"));
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView mav) {
        log.info("◆ 작성 페이지 이동");
        mav.addObject("subjects", gradeService.getSubject());
        mav.setViewName("create");
        return mav;
    }

    @PostMapping("/vote")
    public ResponseEntity<?> vote(
            @RequestBody VoteRequest request
    ) {
        log.info("◆ 유저 투표 처리");
        boolean isSuccess = gradeService.vote(request);
        if (isSuccess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
