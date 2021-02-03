
package drugstore.ukraine.entity;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "family")
@Scope("session")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "family_id")
    private Long familyId;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    @Column(name = "family_name")
    private String familyName;

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return Objects.equals(familyId, family.familyId) &&
                Objects.equals(familyName, family.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyId, familyName);
    }
}

