package com.bloodDonation.mypage.controllers;

import com.bloodDonation.commons.Utils;
import com.bloodDonation.mypage.service.survey.SurveyApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/survey")
@RequiredArgsConstructor
@SessionAttributes("requestSurvey")
public class SurveyController {

    private final Utils utils;
    private final SurveyApplyService applyService;

    @ModelAttribute("requestSurvey")
    public RequestSurvey requestSurvey() {
        return new RequestSurvey();
    }

    @GetMapping("/step1")
    public String step1(@ModelAttribute RequestSurvey form, Model model) {

        return utils.tpl("survey/step1");
    }


    @PostMapping("/step2")
    public String step2(RequestSurvey form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return utils.tpl("survey/step1");
        }

        return utils.tpl("survey/step2");
    }

    @PostMapping("/apply")
    public String apply(RequestSurvey form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return utils.tpl("survey/step2");
        }

        applyService.apply(form);

        return "redirect:/survey/result";
    }
    /*
    @PostMapping("/surveyresult")
    public String surveyresult(RequestSurvey requestSurvey){
        if(survey.getPositive()==11) {

            return utils.tpl("mypage/surveyresult");
        }
        return impossible(survey);
    }
    @PostMapping("/surveyimpossible")
    public String impossible(RequestSurvey requestSurvey){
        if(survey.getNegative() >= 1){
            return utils.tpl("mypage/surveyimpossible");
        }
        return surveyresult(survey);
    }
     */
}
