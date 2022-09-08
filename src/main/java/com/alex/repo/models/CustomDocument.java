package com.alex.repo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customDocuments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomDocument extends RepositoryItem{

    public static final String ORIGINAL_FILE_NAME = "original_file_name";
    public static final String CONVERTED_FILE_NAME = "converted_file_name";
    public static final String DESCRIPTION = "description";
    public static final String USER_ID = "user_id";

    @Column(name = ORIGINAL_FILE_NAME, nullable = false)
    private String originalFileName;

    @Column(name = CONVERTED_FILE_NAME, nullable = false)
    private String convertedFileName;

    @Column(name = DESCRIPTION, nullable = false)
    private String description;

    private String fileType;

    @ManyToOne(optional = false)
    @JoinColumn(name = USER_ID, nullable = false)
    private User user;

    public void addUser(User user) {
        this.user = user;
        user.getCustomDocuments().add(this);
    }

    public void removeUser(User user) {
        this.user = null;
        user.getCustomDocuments().remove(this);
    }

    @Override
    public String toString() {
        return "CustomDocument{" +
                "originalFileName='" + originalFileName + '\'' +
                ", convertedFileName='" + convertedFileName + '\'' +
                ", description='" + description + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
