package com.example.hhparser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String salary;
    private String requirements;
    private String city;
    private String postedDate;

    public Vacancy() {}

    public Vacancy(String title, String company, String salary, String requirements, String city, String postedDate) {
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.requirements = requirements;
        this.city = city;
        this.postedDate = postedDate;
    }

    // геттеры и сеттеры
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }
    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getPostedDate() { return postedDate; }
    public void setPostedDate(String postedDate) { this.postedDate = postedDate; }
}
