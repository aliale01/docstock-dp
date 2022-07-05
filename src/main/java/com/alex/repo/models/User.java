package com.alex.repo.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;
    private String username;
    private String password;
    @Id
    private Long role_roleId;
    @Id
    private Long files_fileid;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "role_roleId")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Files> files;

    public User() {
    }

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

    public Long getRole_roleId() {
        return role_roleId;
    }

    public Long getFiles_fileid() {
        return files_fileid;
    }

    public Role getRole() {
        return role;
    }

    public Set<Files> getFiles() {
        return files;
    }

    //SETTERS

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setFiles(Set<Files> files) {
        this.files = files;
    }
}
