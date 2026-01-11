package parser;

public class Vacancy {
    private String title;
    private String company;
    private String salary;
    private String requirements;
    private String city;
    private String postedDate;

    public Vacancy(String title, String company, String salary, String requirements, String city, String postedDate) {
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.requirements = requirements;
        this.city = city;
        this.postedDate = postedDate;
    }

    public String toCsvLine() {
        return String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"",
                title, company, salary, requirements, city, postedDate);
    }
}
