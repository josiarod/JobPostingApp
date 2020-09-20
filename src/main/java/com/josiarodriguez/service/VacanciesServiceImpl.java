package com.josiarodriguez.service;

import com.josiarodriguez.model.Vacancy;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacanciesServiceImpl implements IVacancyService {

    private List<Vacancy> vacancyList = null;

    public VacanciesServiceImpl() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        vacancyList = new LinkedList<Vacancy>();

        try {

            /////////////////////////////////////
            Vacancy vacancy1 = new Vacancy();
            vacancy1.setId(1);
            vacancy1.setName("App Developer");
            vacancy1.setDescription("Important 500 Company is looking for a Java sr. app developer");
            vacancy1.setDate(sdf.parse("02-24-2020"));
            vacancy1.setSalary(90000.0);
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

    }

    @Override
    public List<Vacancy> searchAll() {
        return vacancyList;
    }

    @Override
    public Vacancy searchById(Integer VacancyId) {
        for (Vacancy v : vacancyList) {
            if (v.getId() == VacancyId) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void save(Vacancy vacancy) {
        vacancyList.add(vacancy);
    }
}
