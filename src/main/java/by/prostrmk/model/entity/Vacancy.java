package by.prostrmk.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Vacancies")
public class Vacancy implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Column(name = "salary")
    private String salary;

    @Column(name = "content")
    private String content;

    public Vacancy() {
    }

    public Vacancy(String username, String title, String salary, String content) {
        this.username = username;
        this.title = title;
        this.salary = salary;
        this.content = content;
    }

    public Vacancy(String username, String title, String date, String salary, String content) {
        this.username = username;
        this.title = title;
        this.date = date;
        this.salary = salary;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", salary='" + salary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
