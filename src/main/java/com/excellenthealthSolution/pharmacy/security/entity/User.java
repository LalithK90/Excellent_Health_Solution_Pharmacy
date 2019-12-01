package com.excellenthealthSolution.pharmacy.security.entity;

import com.excellenthealthSolution.pharmacy.asset.employee.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@JsonIgnoreProperties(value = "createdDate", allowGetters = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(nullable = false, unique = true)
    @Size(min = 5, message = "user name should include at least five characters")
    private String username;

    @Size(min = 4, message = "password should include four characters or symbols")
    @Column(nullable = false)
    @Size(min = 4, message = "password should include four characters or symbols")
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List< Role > roles;

    public User() {
    }

    public Integer getId() {
        return this.id;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public @Size( min = 5, message = "user name should include at least five characters" ) String getUsername() {
        return this.username;
    }

    public @Size( min = 4, message = "password should include four characters or symbols" ) @Size( min = 4, message =
            "password should include four characters or symbols" ) String getPassword() {
        return this.password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public List< Role > getRoles() {
        return this.roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setUsername(@Size( min = 5, message = "user name should include at least five characters" ) String username) {
        this.username = username;
    }

    public void setPassword(@Size( min = 4, message = "password should include four characters or symbols" ) @Size( min = 4, message = "password should include four characters or symbols" ) String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setRoles(List< Role > roles) {
        this.roles = roles;
    }

    public boolean equals(final Object o) {
        if ( o == this ) return true;
        if ( !(o instanceof User) ) return false;
        final User other = (User) o;
        if ( !other.canEqual((Object) this) ) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if ( this$id == null ? other$id != null : !this$id.equals(other$id) ) return false;
        final Object this$employee = this.getEmployee();
        final Object other$employee = other.getEmployee();
        if ( this$employee == null ? other$employee != null : !this$employee.equals(other$employee) ) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if ( this$username == null ? other$username != null : !this$username.equals(other$username) ) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if ( this$password == null ? other$password != null : !this$password.equals(other$password) ) return false;
        if ( this.isEnabled() != other.isEnabled() ) return false;
        final Object this$createdDate = this.getCreatedDate();
        final Object other$createdDate = other.getCreatedDate();
        if ( this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate) )
            return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if ( this$roles == null ? other$roles != null : !this$roles.equals(other$roles) ) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $employee = this.getEmployee();
        result = result * PRIME + ($employee == null ? 43 : $employee.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        result = result * PRIME + (this.isEnabled() ? 79 : 97);
        final Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", employee=" + this.getEmployee() + ", username=" + this.getUsername() +
                ", password=" + this.getPassword() + ", enabled=" + this.isEnabled() + ", createdDate=" + this.getCreatedDate() + ", roles=" + this.getRoles() + ")";
    }
}