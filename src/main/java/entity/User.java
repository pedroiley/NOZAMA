package entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import util.Role;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "users", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @Column(name = "bankAccount")
    private int bankAccount;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public User() {
    }

    public User(String userName, String email, String password, Role role, int bankAccount) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.bankAccount = bankAccount;
    }

    public User(String userName, String email, String password, int bankAccount) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = Role.Regular;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "username=" + userName +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", role=" + role +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
