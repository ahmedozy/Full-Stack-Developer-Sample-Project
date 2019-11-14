package com.k15t.pat.registration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.k15t.pat.model.Participator;

import java.io.StringWriter;

import javax.validation.Valid;
import javax.ws.rs.core.Response;


@Controller
public class RegistrationController {

	@Autowired
	private RegistrationResource regRes;


    @GetMapping("/registration")
    public String registration(Model model) {
    	model.addAttribute("participator", new Participator());
		return "registration";
    }
    
    @PostMapping("/registration")
    public String registration( @ModelAttribute Participator participator, RedirectAttributes redirectAttributes, BindingResult result) {
    	if(result.hasErrors()) {
    		System.out.println("errors");
    		return "registration";
    	}
    	Response res = regRes.save(participator);
    	 if(res.getStatus() == Response.ok().build().getStatus()) {
    		 redirectAttributes.addFlashAttribute("message", "Success");
    		 redirectAttributes.addFlashAttribute("alertClass", "alert-success");
    	 } else {
    		 redirectAttributes.addFlashAttribute("message", "Failed");
    		 redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
    	 }
    	return "redirect:/registration";
    }
}
