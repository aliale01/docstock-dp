package com.alex.repo.models;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "file")
@Table(name = "file")
//@Data - Unsupported
//@NoArgsConstructor - Unsupported
//@AllArgsConstructor - Unsupported
public class File {

    public File() {
    }

    public File(Long file_id, String name, String path, String description, LocalDateTime dateUpload, LocalDateTime dateUpdate, User user, List<Category> categories) {
        this.file_id = file_id;
        this.name = name;
        this.path = path;
        this.description = description;
        this.dateUpload = dateUpload;
        this.dateUpdate = dateUpdate;
        this.user = user;
        this.categories = categories;
    }

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long file_id;
    private String name;
    private String path;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpload;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdate;

    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "files", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> categories;

    //GETTERS
    public Long getFile_id() {
        return file_id;
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

    public LocalDateTime getDateUpload() {
        return dateUpload;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public User getUser() {
        return user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    //SETTERS
    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateUpload(LocalDateTime dateUpload) {
        this.dateUpload = dateUpload;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
