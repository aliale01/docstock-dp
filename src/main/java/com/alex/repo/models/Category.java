package com.alex.repo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "files_category",
    joinColumns = {@JoinColumn (name = "files_fileId")},
    inverseJoinColumns = {@JoinColumn(name = "category_categoryId")})
    private Set<Files> files = new HashSet<>();

    public Category() {
    }

    //GETTERS

    public long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public Set<Files> getFiles() {
        return files;
    }

    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setFiles(Set<Files> files) {
        this.files = files;
    }
}
