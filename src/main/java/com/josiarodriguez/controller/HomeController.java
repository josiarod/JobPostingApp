package com.josiarodriguez.controller;

import com.josiarodriguez.model.Vacancy;
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

    @GetMapping("/table")
    public String showTable(Model model) {
        List<Vacancy> list = getVacancies();
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
       /*
        model.addAttribute("message", "Welcome to Jobs App");
        model.addAttribute("date", new Date());

        */

        String name = "Accountant assistant";
        Date publisDate = new Date();
        double salary = 13000.0;
        boolean available = true;

        model.addAttribute("name", name);
        model.addAttribute("date", publisDate);
        model.addAttribute("salary", salary);
        model.addAttribute("available", available);

        return "home";
    }

    //This method return a list of vacancies.

    private List<Vacancy> getVacancies() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        List<Vacancy> vacancyList = new LinkedList<Vacancy>();

        try {

            /////////////////////////////////////
            Vacancy vacancy1 = new Vacancy();
            vacancy1.setId(1);
            vacancy1.setName("App Developer");
            vacancy1.setDescription("Important 500 Company is looking for a Java sr. app developer");
            vacancy1.setDate(sdf.parse("02-24-2020"));
            vacancy1.setSalary(80000.0);
            vacancy1.setHighlighted(1);
            vacancy1.setImage("company1.png");


            /////////////////////////////////
            Vacancy vacancy2 = new Vacancy();
            vacancy2.setId(2);
            vacancy2.setName("Web Designer");
            vacancy2.setDescription("Fast groing startup need experienced Web Designer");
            vacancy2.setDate(sdf.parse("02-12-2020"));
            vacancy2.setSalary(50000.0);
            vacancy2.setHighlighted(0);
            vacancy2.setImage("company2.png");

            /////////////////////////////////
            Vacancy vacancy3 = new Vacancy();
            vacancy3.setId(3);
            vacancy3.setName("Yoga Instructor");
            vacancy3.setDescription("Yoga studio looking for Yoga Instructors");
            vacancy3.setDate(sdf.parse("03-23-2020"));
            vacancy3.setSalary(30000.0);
            vacancy3.setHighlighted(0);

            /////////////////////////////////
            Vacancy vacancy4 = new Vacancy();
            vacancy4.setId(4);
            vacancy4.setName("Mechanic");
            vacancy4.setDescription("Moving company is looking for a mechanic");
            vacancy4.setDate(sdf.parse("03-15-2020"));
            vacancy4.setSalary(30000.0);
            vacancy4.setHighlighted(1);
            vacancy4.setImage("company4.png");

            //////////////////////////////////////
            vacancyList.add(vacancy1);
            vacancyList.add(vacancy2);
            vacancyList.add(vacancy3);
            vacancyList.add(vacancy4);

        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return vacancyList;

    }
}

