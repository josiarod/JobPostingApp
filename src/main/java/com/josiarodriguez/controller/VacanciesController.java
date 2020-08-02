package com.josiarodriguez.controller;

import com.josiarodriguez.model.Vacancy;
import com.josiarodriguez.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacancies")
public class VacanciesController {

    @Autowired
    private IVacancyService vacancyService;

    @GetMapping("/create")
    public String create(){
        return "vacancies/vacancyForm";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("description") String description,@RequestParam("status") String status,
                       @RequestParam("date") String date, @RequestParam("highlighted") int highlighted,
                       @RequestParam("salary") double salary,@RequestParam("details") String details){
        System.out.println("Vacancy Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Publication Date: " + date);
        System.out.println("Highlighted: " + highlighted);
        System.out.println("Offered Salary: " + salary);
        System.out.println("Details: " + details);
        return "vacancies/vacanciesList";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("id") int vacancyId, Model model){
        System.out.println("Deleting vacancy with id: " + vacancyId);
       model.addAttribute("id", vacancyId);
        return "message";
    }

    @GetMapping("/view/{id}")
    public String seeDetails(@PathVariable("id") int vacancyId, Model model){
        Vacancy vacancy = vacancyService.searchById(vacancyId);
       System.out.println("Vacancy: " + vacancy);
       model.addAttribute("vacancy", vacancy);
       //Find vacancy details using id in the DB...
       return "details";
    }
}
