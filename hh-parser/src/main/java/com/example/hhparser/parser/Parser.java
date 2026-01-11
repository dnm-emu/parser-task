package com.example.hhparser.parser;

import com.example.hhparser.model.Vacancy;

public interface Parser {
    Vacancy parse(String url);
}
