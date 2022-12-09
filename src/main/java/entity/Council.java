package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "council")
public class Council {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private ProjectStudent projectStudent;

    @Column
    private int numberLecturers;

    @Column
    private Date dateCounterArgument;

    @ManyToOne
    private User leader;

    @Column
    private String status;

    @OneToMany(mappedBy = "council", cascade = CascadeType.ALL)
    private List<MemberCouncil> memberCouncils;

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

    public List<MemberCouncil> getMemberCouncils() {
        return memberCouncils;
    }

    public void setMemberCouncils(List<MemberCouncil> memberCouncils) {
        this.memberCouncils = memberCouncils;
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