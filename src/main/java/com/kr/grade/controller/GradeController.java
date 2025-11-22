package com.kr.grade.controller;

import com.kr.grade.service.GradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {

        mav.addObject("categories", gradeService.getCategory());
        mav.addObject("subjectCount", gradeService.getSubjectCount());
        mav.setViewName("index");

        return mav;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

}
