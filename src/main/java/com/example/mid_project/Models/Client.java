package com.example.mid_project.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be null")
    @Column(name = "varchar(25) not null")
    private String name;

    @NotEmpty(message = "commercial Registration should not be null")
    @Column(name = "varchar(12) not null unique")
    private String commercialRecord;

    @NotEmpty(message = "email should not be null")
    @Email
    @Column(name = "varchar(25) not null unique")
    private String email;


    @NotEmpty(message = "phone should not be null")
    @Column(columnDefinition = "varchar(15) not null unique")
    private String phoneNumber;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Project> projects;

}
