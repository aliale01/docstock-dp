package com.alex.repo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "files")
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fieldId;
    private String name;
    private String path;
    private String description;
    private java.sql.Date dateUpload;

    @ManyToOne
    @JoinColumn(name = "files_fileId", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private Set<Category> categories = new HashSet<>();

    public Files() {
    }

    //GETTERS

    public Long getFieldId() {
        return fieldId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateUpload() {
        return dateUpload;
    }

    public User getUser() {
        return user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    //SETTERS

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCategory(Category category){
        categories.add(category);
        category.getFiles().add(this);
    }
}
