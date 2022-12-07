package models;

import entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class StudentGroupModel {
    private int id;

    @Column
    private String name;

    @ManyToOne
    private User user;

    @Column
    private String leader;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
}
