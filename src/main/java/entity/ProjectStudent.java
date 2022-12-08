package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projectStudent")
public class ProjectStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private ProjectLecturers projectLecturers;

    @Column
    private String status;

    @Column
    private  String reviews;

    @Column
    private int point;

    @Column
    private String statusArgument;

    @Column
    private Date createAt;

    @OneToMany(mappedBy = "projectStudent", cascade = CascadeType.ALL)
    private List<Council> councils;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProjectLecturers getProjectLecturers() {
        return projectLecturers;
    }

    public void setProjectLecturers(ProjectLecturers projectLecturers) {
        this.projectLecturers = projectLecturers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getStatusArgument() {
        return statusArgument;
    }

    public void setStatusArgument(String statusArgument) {
        this.statusArgument = statusArgument;
    }

    public List<Council> getCouncils() {
        return councils;
    }

    public void setCouncils(List<Council> councils) {
        this.councils = councils;
    }
}
