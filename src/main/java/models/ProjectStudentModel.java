package models;

import entity.ProjectLecturers;
import entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ProjectStudentModel {

    private int id;

    private String status;

    private int point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private Date createAt;
}
