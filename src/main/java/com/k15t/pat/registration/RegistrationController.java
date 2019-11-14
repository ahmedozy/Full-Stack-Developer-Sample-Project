package com.k15t.pat.registration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.StringWriter;


@Controller
public class RegistrationController {



    @GetMapping("/registration")
    public String registration() {
		return "registration";
    }
}
