package com.alex.repo.models;

import lombok.*;

import javax.persistence.*;

@Entity(name = "role")
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    private String name;
    private String description;

    @OneToOne(mappedBy = "role")
    private User user;

}
