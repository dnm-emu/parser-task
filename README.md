HH Parser — Руководство по запуску и проверке
Описание проекта

Spring Boot приложение для парсинга вакансий с сайта hh.ru.

Особенности:

Многопоточный парсинг через ExecutorService.

Автосохранение вакансий в встроенную H2 базу.

REST API для запуска парсинга и получения результатов.

H2 консоль для просмотра данных.

Автозапуск тестовых вакансий для проверки без ручного ввода ссылок.

Требования

Java 17+

Maven

IntelliJ IDEA (или другая IDE с поддержкой Spring Boot)

Структура проекта
hh-parser/
 ├─ src/main/java/com/example/hhparser/
 │    ├─ HhParserApplication.java
 │    ├─ parser/
 │    │    ├─ Parser.java
 │    │    └─ HHParser.java
 │    ├─ model/
 │    │    └─ Vacancy.java
 │    ├─ repository/
 │    │    └─ VacancyRepository.java
 │    ├─ service/
 │    │    └─ VacancyService.java
 │    └─ controller/
 │         └─ VacancyController.java
 └─ src/main/resources/
 │      └─ application.properties
 └─ pom.xml
 └─ README.md

Сборка и запуск проекта

Открыть проект в IntelliJ IDEA: File → Open → hh-parser

Проверить JDK (17+)

Build → Rebuild Project

Найти класс HhParserApplication.java

Правая кнопка → Run 'HhParserApplication'

Консоль должна показать:

Tomcat started on port(s): 8080 (http)
H2 console available at '/h2-console'
Started HhParserApplication

Автозапуск тестовых вакансий

Для проверки добавлен автозапуск в VacancyService:

@PostConstruct
public void init() {
    List<String> testUrls = List.of(
        "https://tyumen.hh.ru/vacancy/128917418?from=applicant_recommended&hhtmFrom=main",
                "https://tyumen.hh.ru/vacancy/128999688?from=applicant_recommended&hhtmFrom=main",
                "https://tyumen.hh.ru/vacancy/126428618?from=applicant_recommended&hhtmFrom=main",
                "https://tyumen.hh.ru/vacancy/128993305?hhtmFrom=vacancy_search_list",
                "https://tyumen.hh.ru/vacancy/129168773?hhtmFrom=vacancy_search_list"
    );
    parseVacancies(testUrls);
}


После старта приложения вакансии автоматически сохраняются в базу H2.

 Просмотр результатов через REST API
Получение всех вакансий

GET http://localhost:8080/api/vacancies

Пример curl:

curl http://localhost:8080/api/vacancies


Возвращает JSON с вакансиями.

Опционально: запустить новый парсинг вручную

POST http://localhost:8080/api/parse

Body (JSON):

{
  "urls": [
    "https://hh.ru/vacancy/129168773",
    "https://hh.ru/vacancy/128917418"
  ]
}

 Просмотр базы H2

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:vacanciesdb

User: sa

Password: (оставить пустым)

Connect → таблица VACANCY содержит все вакансии.

Примечания для преподавателя

Преподавателю не нужно вводить ссылки вручную: тестовые вакансии уже добавлены и будут автоматически распарсены.

Парсинг многопоточный (ExecutorService) — данные сохраняются сразу.

H2 база встроенная — не требуется настраивать внешние СУБД.

Для проверки работы достаточно:

Запустить HhParserApplication.java

Перейти на /api/vacancies или /h2-console

Убедиться, что вакансии появились
