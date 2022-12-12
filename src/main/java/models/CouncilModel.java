package models;

import entity.ProjectLecturers;
import entity.ProjectStudent;
import entity.User;

import java.util.Date;

public class CouncilModel {
    private int id;

    private ProjectStudent projectStudent;

    private int numberLecturers;

    private Date dateCounterArgument;

    private User leader;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectStudent getProjectStudent() {
        return projectStudent;
    }

    public void setProjectStudent(ProjectStudent projectStudent) {
        this.projectStudent = projectStudent;
    }

    public int getNumberLecturers() {
        return numberLecturers;
    }

    public void setNumberLecturers(int numberLecturers) {
        this.numberLecturers = numberLecturers;
    }

    public Date getDateCounterArgument() {
        return dateCounterArgument;
    }

    public void setDateCounterArgument(Date dateCounterArgument) {
        this.dateCounterArgument = dateCounterArgument;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}