package com.group2.library_management.entity;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = true)
    private String name;
    private String address;
    @Column(name = "established_year")
    private Year establishedYear;
    @Column(length = 255)
    private String email;
    @Column(length = 20)
    private String phone;
    @Column(length = 255)
    private String website;
    private String description;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Edition> editions = new ArrayList<>();
}
