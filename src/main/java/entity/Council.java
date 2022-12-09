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
    @Column
    private int numberLecturers;
    @Column
    private Date dateCounterArgument;
    @OneToMany(mappedBy = "council", cascade = CascadeType.ALL)
    private List<MemberCouncil> memberCouncils;
    @OneToMany(mappedBy = "council", cascade = CascadeType.ALL)
    private List<ProjectStudent> projectStudents;
    @ManyToOne
    private MemberCouncil lead;

}
