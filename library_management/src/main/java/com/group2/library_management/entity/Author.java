package com.group2.library_management.entity;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50,nullable = true)
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private String biography;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    public List<AuthorBook> authorBooks = new ArrayList<>();
}
