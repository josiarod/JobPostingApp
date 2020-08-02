package com.josiarodriguez.controller;

import com.josiarodriguez.model.Vacancy;
import com.josiarodriguez.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IVacancyService vacancyService;

    @GetMapping("/table")
    public String showTable(Model model) {
        List<Vacancy> list = vacancyService.searchAll();
        model.addAttribute("vacancies", list);

        return "table";
    }


    @GetMapping("/details")
    public String showDetails(Model model) {
        Vacancy vacancy = new Vacancy();
        vacancy.setName("Software Engineer");
        vacancy.setDescription("We are looking for a Java jr. web developer");
        vacancy.setDate(new Date());
        vacancy.setSalary(60000.0);
        model.addAttribute("vacancy", vacancy);
        return "details";

    }

    @GetMapping("list")
    public String showList(Model model) {
        List<String> list = new LinkedList<>();
        list.add("Software Engineer");
        list.add("Accountant Assistant");
        list.add("Sales Person");
        list.add("Architect");

        model.addAttribute("jobs", list);
        return "list";
    }


    @GetMapping("/")
    public String showHome(Model model) {
        List<Vacancy> list = vacancyService.searchAll();
        model.addAttribute("vacancies", list);
        return "home";
    }
}

