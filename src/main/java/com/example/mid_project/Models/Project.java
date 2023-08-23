package com.example.mid_project.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;
import java.util.Set;

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

    @NotEmpty(message = "description must not be empty")
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String description;


    @NotEmpty(message = "please enter define type of project")
    @Pattern(regexp = "(technical|operation|construction)")
    @Column(columnDefinition = "varchar(12) not null check(type = 'technical' or type = 'operation' or type = 'construction' )")
    private String type;

    //    @NotEmpty(message = "status must not be empty")
    @Pattern(regexp = "(waiting|in progress|finish)")
    @Column(columnDefinition = "varchar(25) default 'waiting' check(status='finish' or status='waiting' or status='in progress')")
    private String status;

    @Column(columnDefinition = "varchar(25) not null")
    @NotEmpty(message = "submission deadline must not be empty")
    private String submission_deadline;

    @NotNull(message = "documents  price  must not be empty")
    @Column(columnDefinition = "int not null")
    private Integer documentation_price;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonIgnore
    private Client client;


    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    @JsonIgnore
    private Provider provider;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Request> requests;
}
