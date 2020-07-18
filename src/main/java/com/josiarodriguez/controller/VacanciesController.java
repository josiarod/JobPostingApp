package com.josiarodriguez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacancies")
public class VacanciesController {
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int vacancyId, Model model){
        System.out.println("Deleting vacancy with id: " + vacancyId);
       model.addAttribute("id", vacancyId);
        return "message";
    }

    @GetMapping("/view/{id}")
    public String seeDetails(@PathVariable("id") int vacancyId, Model model){
       System.out.println("Vacancy Id: " + vacancyId);
       model.addAttribute("vacancyId", vacancyId);
       //Find vacancy details using id in the DB...
       return "vacancies/detail";
    }
}
