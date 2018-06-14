package by.prostrmk.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Resume")
public class Resume implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "university")
    private String university;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public Resume() {
    }

    public Resume(String username, String university, String title, String content) {
        this.username = username;
        this.university = university;
        this.title = title;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", university='" + university + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
