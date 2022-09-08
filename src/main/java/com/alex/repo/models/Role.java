package com.alex.repo.models;

import com.alex.repo.dto.RoleDTO;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Role extends RepositoryItem implements GrantedAuthority {

    @Column(nullable = false, unique = true, length = 80)
    private String roleName;

    @Column(nullable = false, unique = true)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(RoleDTO roleDTO) {
        this.roleName = roleDTO.getRoleName();
        this.description = roleDTO.getDescription();
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName);
    }
}
