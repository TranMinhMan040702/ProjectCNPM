package models;

import entity.ProjectLecturers;
import entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ProjectStudentModel {
    private int id;

    private User user;

    private ProjectLecturers projectLecturers;

    private String status;

    private int point;

    private Date createAt;

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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}