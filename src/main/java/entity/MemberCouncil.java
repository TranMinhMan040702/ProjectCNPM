package entity;

import javax.persistence.*;

@Entity
@Table(name = "memberCouncil")
public class MemberCouncil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private Council council;

    @ManyToOne
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
