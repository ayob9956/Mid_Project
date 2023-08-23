package com.example.mid_project.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name must Not be empty")
    @Column(columnDefinition = "varchar(25)", nullable = false)
    private String name;
    @NotEmpty(message ="description must not be empty")
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String description;
    @NotEmpty(message ="type must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String type;

    @NotEmpty(message ="status must not be empty")
    @Column(columnDefinition = "varchar(25) not null check(status='finish' or status='waiting' or status='in-progress'")
    private String status;
    @Column(columnDefinition = "DATE not null")
    @NotEmpty(message ="submission deadline must not be empty")
    private String submission_deadline;

    @NotNull(message ="documents  price  must not be empty")
    @Column(columnDefinition = "int not null")
    private Integer documentation_price;

}
