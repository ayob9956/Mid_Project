package com.example.mid_project.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
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
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "provider name must not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String providerName;

    @NotEmpty(message = "details must not be empty")
    @Column(columnDefinition = "varchar(150) not null")
    private String details;

    @NotNull(message = "budget must not be null")
    @Column(columnDefinition = "integer not null")
    private Integer budget;

    @NotEmpty(message = "duration must not be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String duration;


    @AssertFalse
    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;

}
