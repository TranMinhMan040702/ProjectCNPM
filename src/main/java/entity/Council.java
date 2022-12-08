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

    @OneToMany(mappedBy = "council", cascade = CascadeType.ALL)
    private List<ProjectStudent> projectStudents;

    public List<ProjectStudent> getProjectStudents() {
        return projectStudents;
    }

    public void setProjectStudents(List<ProjectStudent> projectStudents) {
        this.projectStudents = projectStudents;
    }

    @Column
    private int numberLecturers;

    @ManyToOne
    private MemberCouncil lead;

    public MemberCouncil getLead() {
        return lead;
    }

    public void setLead(MemberCouncil lead) {
        this.lead = lead;
    }

    @Column
    private Date dateCounterArgument;

    @OneToMany(mappedBy = "council", cascade = CascadeType.ALL)
    private List<MemberCouncil> memberCouncils;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
