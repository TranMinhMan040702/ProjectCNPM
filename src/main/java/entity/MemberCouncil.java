package entity;

import javax.persistence.*;
import java.util.List;

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
    private User user;
}
