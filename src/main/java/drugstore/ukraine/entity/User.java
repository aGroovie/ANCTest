package drugstore.ukraine.entity;

import drugstore.ukraine.enums.EducationType;
import drugstore.ukraine.enums.MaritalStatus;
import drugstore.ukraine.enums.Role;
import drugstore.ukraine.enums.Status;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Scope("session")
@Table(name = "users")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    @Size(min = 5, max = 10, message = "Username must be between {min} and {max}")
    private String username;

    @Column(name = "user_pw")
    @NotNull
    @Size(min = 6, max = 14, message = "Password must be between {min} and {max}")
    private String password;

    @Column(name = "user_fname")
    @NotNull
    @Size(min = 2, max = 16, message = "First name must be between {min} and {max}")
    private String firstName;

    @Column(name = "user_sname")
    @NotNull
    @Size(min = 2, max = 16, message = "Second name must be between {min} and {max}")
    private String secondName;

    @Column(name = "user_mname")
    @NotNull
    @Size(min = 2, max = 16, message = "Second name must be between {min} and {max}")
    private String middleName;

    @Column(name = "user_itn")
    @NotNull
    @Size(min = 10, max = 10, message = "ITN must be 10 digits length!")
    private String itNumber;

    @Column(name = "user_mat_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "user_ed_type")
    @Enumerated(EnumType.STRING)
    private EducationType educationType;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_family_id")
    Family family;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public EducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getItNumber() {
        return itNumber;
    }

    public void setItNumber(String itNumber) {
        this.itNumber = itNumber;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(middleName, user.middleName) &&
                Objects.equals(itNumber, user.itNumber) &&
                maritalStatus == user.maritalStatus &&
                educationType == user.educationType &&
                userRole == user.userRole &&
                status == user.status &&
                Objects.equals(family, user.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, firstName, secondName, middleName, itNumber, maritalStatus, educationType, userRole, status, family);
    }
}
