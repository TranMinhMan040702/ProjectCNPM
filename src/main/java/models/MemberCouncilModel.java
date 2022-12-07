package models;

import entity.Council;
import entity.ProjectLecturers;


public class MemberCouncilModel {
    private int id;

    private Council council;

    private ProjectLecturers projectLecturers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Council getCouncil() {
        return council;
    }

    public void setCouncil(Council council) {
        this.council = council;
    }

    public ProjectLecturers getProjectLecturers() {
        return projectLecturers;
    }

    public void setProjectLecturers(ProjectLecturers projectLecturers) {
        this.projectLecturers = projectLecturers;
    }
}
