package models;

import entity.ProjectLecturers;

import java.util.Date;

public class CouncilModel {
    private int id;

    private ProjectLecturers projectLecturers;

    private int numberLecturers;

    private Date dateCounterArgument;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectLecturers getProjectLecturers() {
        return projectLecturers;
    }

    public void setProjectLecturers(ProjectLecturers projectLecturers) {
        this.projectLecturers = projectLecturers;
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
}
