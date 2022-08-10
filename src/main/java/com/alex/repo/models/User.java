package com.alex.repo.models;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
@Table(name = "user")
//@Data - Unsupported
//@NoArgsConstructor - Unsupported
//@AllArgsConstructor - Unsupported
public class User {

    public User() {
    }

    public User(Long userId, String username, String password, Role role, Set<File> files) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.files = files;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String password;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "role_role_id")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<File> files;

    //GETTERS
    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Set<File> getFiles() {
        return files;
    }

    //SETTERS
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }
}
