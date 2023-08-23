package com.example.mid_project.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name must not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String name;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "please enter valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotNull(message = "name must not be empty")
    @Size(min = 10, max = 10, message = "phone must be 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phone;

    @NotNull(message = "balance must be not null")
    @Positive(message = "balance must be positive number")
    @Column(columnDefinition = "integer not null default 1500")
    private Integer balance;

    @NotEmpty(message = "commercial record is important")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String commercialRecord;

    @NotEmpty(message = "please enter define type of provider")
    @Pattern(regexp = "(technical|operation|construction)")
    @Column(columnDefinition = "varchar(12) not null check(provider_type = 'technical' or provider_type = 'operation' or provider_type = 'construction' )")
    private String providerType;
}
