package com.alex.repo.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = RefreshToken.COLUMN)
public class RefreshToken extends RepositoryItem {

    static final String COLUMN = "refresh_token";

    private String token;
}
