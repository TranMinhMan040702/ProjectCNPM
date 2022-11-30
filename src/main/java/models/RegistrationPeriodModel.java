package models;

import javax.persistence.Column;
import java.util.Date;

public class RegistrationPeriodModel {
    private int id;
    private Date startday;
    private Date endday;
    private String role;
    private String department;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartday() {
        return startday;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    public Date getEndday() {
        return endday;
    }

    public void setEndday(Date endday) {
        this.endday = endday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
