package models;

import entity.Council;
import entity.ProjectLecturers;
import entity.User;


public class MemberCouncilModel {
    private int id;

    private Council council;


    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
