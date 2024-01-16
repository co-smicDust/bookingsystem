package com.bloodDonation.mypage.controllers;


import com.bloodDonation.commons.ExceptionProcessor;
import com.bloodDonation.commons.Utils;
import com.bloodDonation.member.MemberUtil;
import com.bloodDonation.member.controllers.RequestJoin;
import com.bloodDonation.member.entities.Member;
import com.bloodDonation.mypage.service.MyPageModifyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController implements ExceptionProcessor {

    private final Utils utils;
    private final MyPageModifyService service;
    private final MemberUtil memberUtil;

    @ModelAttribute("addCss")
    public String[] getAddCss() {

        return new String[] { "mypage/style" };
    }

    @ModelAttribute("addScript")
    public String[] getAddScript() {

        return new String[] { "mypage/common"};
    }

    /**
     * 마이페이지 첫 화면
     *
     * @param model
     * @return
     */
    @GetMapping
    public String index(Model model) {
        commonProcess("main", model);

        return utils.tpl("mypage/index");
    }

    @GetMapping("/info")
    public String info(Model model) {
        commonProcess("info", model);


        return utils.tpl("mypage/info");
    }

    @GetMapping("/modify")
    public String modifiy(@ModelAttribute RequestJoin form, Model model) {
        commonProcess("modify", model);

        if (memberUtil.isLogin()) {
            Member member = memberUtil.getMember();
            form.setUserId(member.getUserId());
            form.setMName(member.getMName());
        }

        return utils.tpl("mypage/modify");
    }

    @PostMapping("/modify222")
    public String modifiy22(@RequestBody Member member) {
        service.modifyMyInfo(member);
        return utils.tpl("mypage/modify");
    }

    @PostMapping("/modify")
    public String modifyPs(@Valid RequestJoin form, Model model) {
        commonProcess("modify", model);
        //변경된 개인정보가 requestjoin에 저장되야됨-null체크 필수?
        if (memberUtil.isLogin()) {
            Member member = memberUtil.getMember();
            form.setUserPw(member.getUserPw());
            form.setConfirmPassword(member.getConfirmPassword());
            form.setEmail(member.getEmail());
            //form.setZonecode(member.getZonecode());
        }
        return "redirect:/mypage/info";
    }
    @GetMapping("/reservation")
    public String reservation(Model model){
        commonProcess("reservation", model);
        return utils.tpl("mypage/reservation");
    }

     @GetMapping("/reservation/modify")
     public String reservationModify(Model model){
            commonProcess("reservation/modify",model);
            return utils.tpl("mypage/reservation_modify");
     }

    @GetMapping("/survey")
    public String survey(Model model){
        commonProcess("survey", model);
        return utils.tpl("mypage/survey");
    }
    @GetMapping("/dosurvey")
    public String dosurvey(Model model){
        commonProcess("dosurvey", model);
        return utils.tpl("mypage/dosurvey");
    }

    @GetMapping("/bloodview")
    public String bloodview(Model model){
        commonProcess("bloodview", model);
        return utils.tpl("mypage/bloodview");
    }
    @GetMapping("/surveyresult")
    public String surveyResult(Model model){
        commonProcess("surveyresult", model);
        return utils.tpl("mypage/surveyresult");
    }
    @GetMapping("/unregister")
    public String unregister(Model model){
        commonProcess("unregister", model);
        return utils.tpl("mypage/unregister");
    }

    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "main");
        String pageTitle = Utils.getMessage("마이페이지", "commons");

        if (mode.equals("info")) {
            pageTitle = Utils.getMessage("개인정보_조회", "commons");
        } else if (mode.equals("modify")) {
            pageTitle = Utils.getMessage("개인정보_변경", "commons");
        } else if (mode.equals("reservation")) {
            pageTitle = Utils.getMessage("예약조회", "commons");
        } else if (mode.equals("reservation/modify")) {
            pageTitle = Utils.getMessage("예약변경", "commons");
        } else if (mode.equals("survey")) {
                pageTitle = Utils.getMessage("전자문진안내", "commons");
        } else if (mode.equals("dosurvey")) {
            pageTitle = Utils.getMessage("전자문진", "commons");
        } else if (mode.equals("bloodview")) {
            pageTitle = Utils.getMessage("나의_헌혈내역", "commons");
        } else if (mode.equals("surveyresult")) {
            pageTitle = Utils.getMessage("검사결과", "commons");
        } else {
            if(mode.equals("unregister")) {
                pageTitle = Utils.getMessage("회원탈퇴", "commons");
            }
        }


            model.addAttribute("pageTitle", pageTitle);
    }

}
