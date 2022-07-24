package com.alex.repo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "category")
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "file_has_category",
    joinColumns = {@JoinColumn (name = "file_file_id"),
            @JoinColumn (name = "file_user_user_id"),
            @JoinColumn (name = "file_user_role_role_id")},
    inverseJoinColumns = {@JoinColumn(name = "category_category_id")}
    )
    private Set<File> files = new HashSet<>();

}
