package domain;

/**
 * Created by Андрей on 03.01.2016.
 */
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Role_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID_ROLE")
    private Long idRole;
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String description) {
        this.description = description;
    }

    public Long getIdRole() {
        return idRole;
    }
}
