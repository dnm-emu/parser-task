package com.example.hhparser.service;

import com.example.hhparser.model.Vacancy;
import com.example.hhparser.parser.Parser;
import com.example.hhparser.repository.VacancyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class VacancyService {

    private final VacancyRepository repository;
    private final Parser parser;
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public VacancyService(VacancyRepository repository, Parser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    public void parseVacancies(List<String> urls) {
        for (String url : urls) {
            executor.submit(() -> {
                Vacancy vacancy = parser.parse(url);
                if (vacancy != null) {
                    repository.save(vacancy);
                }
            });
        }
    }

    public List<Vacancy> getAllVacancies() {
        return repository.findAll().parallelStream().toList();
    }
}
