package com.example.hhparser.controller;

import com.example.hhparser.model.Vacancy;
import com.example.hhparser.service.VacancyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyService service;

    public VacancyController(VacancyService service) {
        this.service = service;
    }

    @PostMapping("/parse")
    public String parseVacancies(@RequestBody List<String> urls) {
        service.parseVacancies(urls);
        return "Parsing started";
    }

    @GetMapping("/answer")
    public List<Vacancy> getVacancies() {
        return service.getAllVacancies();
    }
}
