package com.alex.repo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "file")
@Table(name = "file")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;
    private String name;
    private String path;
    private String description;
    private Timestamp dateUpload;
    private Timestamp dateUpdate;

    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

    @ManyToMany(mappedBy = "files", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Category> categories = new HashSet<>();

}
