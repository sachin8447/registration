package com.techphantoms.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/")
    public String index() {
        return "dashboard/index";
    }


}
