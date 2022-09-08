package com.alex.repo.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Andrii Borozdykh
 */


@Getter
@Setter
@MappedSuperclass
public abstract class RepositoryItem {

    private static final String ID = "id";
    private static final String DATETIME_UTC = "timestamptz(0)";
    private static final String CREATED_DATE_TIME = "created";
    private static final String UPDATE_DATE_TIME = "updated";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = ID)
    @Access(AccessType.PROPERTY)
    private String id;
}
