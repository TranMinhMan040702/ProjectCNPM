package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projectLecturers")
public class ProjectLecturers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private User user;

    @Column
    private String topic;

    @Column
    private String target;

    @Column
    private String request;

    @Column
    private String department;

    @Column
    private Date createAt;

    @OneToMany(mappedBy = "projectLecturers", cascade = CascadeType.ALL)
    private List<ProjectStudent> projectStudents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<ProjectStudent> getProjectStudents() {
        return projectStudents;
    }

    public void setProjectStudents(List<ProjectStudent> projectStudents) {
        this.projectStudents = projectStudents;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


}