package com.example.hhparser.parser;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<String> urls = List.of(
                "https://tyumen.hh.ru/vacancy/128917418?from=applicant_recommended&hhtmFrom=main",
                "https://tyumen.hh.ru/vacancy/128999688?from=applicant_recommended&hhtmFrom=main",
                "https://tyumen.hh.ru/vacancy/126428618?from=applicant_recommended&hhtmFrom=main",
                "https://tyumen.hh.ru/vacancy/128993305?hhtmFrom=vacancy_search_list",
                "https://tyumen.hh.ru/vacancy/129168773?hhtmFrom=vacancy_search_list"
        );

        for (String url : urls) {
            executor.submit(() -> {
                System.out.println("Parsing: " + url);
            });
        }

        executor.shutdown();
    }
}
