package com.bloodDonation.admin.controllers;


import com.bloodDonation.commons.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMainController")
@RequestMapping("/admin")
public class MainController implements ExceptionProcessor {

    @GetMapping
    public String index() {
        return "/admin/main/index";
    }
}
