package com.falcon.TimeTableGenerator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
@Data
@Entity
@Getter
@Setter
@ToString
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Course> courses;
    @OneToMany(mappedBy = "department")
    private Set<Teacher> teachers;
}
