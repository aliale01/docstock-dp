package com.alex.repo.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User extends RepositoryItem{

    // JPA define fields
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String USER_ID = "user_id";
    private static final String ROLE_ID = "role_id";
    private static final String USERS_ROLES = "users_roles";

    private static final String USER = "user";

    @Column(name = USERNAME, nullable = false, unique = true)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @ManyToMany()
    @JoinTable(name = USERS_ROLES,
            joinColumns = @JoinColumn(name = USER_ID),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = USER, fetch = FetchType.LAZY)
    private List<CustomDocument> customDocuments = new ArrayList<>();

    public void addRole(Role role){
        if(this.getRoles() == null){
            this.roles = new HashSet<>();
        }
        this.getRoles().add(role);
    }

    public void removeRole(Role role){
        this.getRoles().remove(role);
        role.getUsers().remove(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // что тут происходит
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
