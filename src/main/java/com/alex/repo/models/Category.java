package com.alex.repo.models;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
@Table(name = "category")
//@Data - Unsupported
//@NoArgsConstructor - Unsupported
//@AllArgsConstructor - Unsupported
public class Category {

    public Category() {
    }

    public Category(Long category_id, String name, List<File> files) {
        this.category_id = category_id;
        this.name = name;
        this.files = files;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "file_has_category",
    joinColumns = {@JoinColumn(name = "category_category_id")},
    inverseJoinColumns = {@JoinColumn (name = "file_file_id")}
    )
    private List<File> files;

    //GETTERS
    public Long getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
        return files;
    }

    //SETTERS
    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
