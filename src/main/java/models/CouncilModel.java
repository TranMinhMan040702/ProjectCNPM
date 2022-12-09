package models;

import entity.MemberCouncil;
import entity.ProjectLecturers;
import entity.ProjectStudent;

import java.util.Date;

public class CouncilModel {
    private int id;

    private ProjectStudent projectStudent;
    private MemberCouncil lead;

    public MemberCouncil getLead() {
        return lead;
    }

    public void setLead(MemberCouncil lead) {
        this.lead = lead;
    }

    private int numberLecturers;

    private Date dateCounterArgument;

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
}
