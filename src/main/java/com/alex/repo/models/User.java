package com.alex.repo.models;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity(name = "user")
@Table(name = "user")
//@Data - Unsupported
//@NoArgsConstructor - Unsupported
//@AllArgsConstructor - Unsupported
public class User {

    public User() {
    }

    public User(Long userId, String username, String password, Collection<Role> roles, Set<File> files) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.files = files;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String password;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_role",
            joinColumns = {@JoinColumn(name = "user_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_role_id")})
    private Collection<Role> roles;

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

    public Collection<Role> getRoles() {
        return roles;
    }

    public Set<File> getFiles() {
        return files;
    }

    //SETTERS
    public void setUserId(Long userId) {
        this.userId = userId;
    } //?

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }//?

    public void setFiles(Set<File> files) {
        this.files = files;
    }//?
}
