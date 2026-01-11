package com.example.hhparser.parser;

import com.example.hhparser.model.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class HHParser implements Parser {

    @Override
    public Vacancy parse(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/116.0.0.0 Safari/537.36")
                    .timeout(10000) // 10 секунд
                    .get();

            String title = getTextOrDefault(doc, "h1[data-qa='vacancy-title']", "Не указано");
            String company = getTextOrDefault(doc, "a[data-qa='vacancy-company-name']", "Не указано");
            String salary = getTextOrDefault(doc, "span[data-qa='vacancy-salary']", "Не указано");
            String city = getTextOrDefault(doc, "span[data-qa='vacancy-view-location']", "Не указано");
            String postedDate = getTextOrDefault(doc, "p[data-qa='vacancy-view-ago']", "Не указано");
            String requirements = getTextOrDefault(doc, "div[data-qa='vacancy-description']", "Не указано");

            return new Vacancy(title, company, salary, requirements, city, postedDate);

        } catch (Exception e) {
            System.err.println("Failed to parse: " + url + " | " + e.getMessage());
            return null;
        }
    }

    private String getTextOrDefault(Document doc, String selector, String defaultValue) {
        return doc.selectFirst(selector) != null ? doc.selectFirst(selector).text() : defaultValue;
    }
}
