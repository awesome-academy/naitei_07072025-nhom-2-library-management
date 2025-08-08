package com.group2.library_management.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "editions")
public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20, unique = true)
    private String isbn;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(length = 50)
    private String language;
    @Column(name = "page_number")
    private Integer pageNumber;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @Column(length = 255)
    private String coverImageUrl;
    @Column(name = "initial_quantity",nullable = false)
    private Integer initialQuantity;
    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;
    private Integer format;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id",referencedColumnName = "id")
    private Publisher publisher;
    @OneToMany(mappedBy = "edition",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "edition",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Ratting> rattings = new ArrayList<>();
    @OneToMany(mappedBy = "edition",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BookInstance> bookInstances = new ArrayList<>();

    public String getFormatString(){
        BookFormat bookFormat = BooFormat.fromValue(this.format);
        return bookFormat.getFormatString();
    }
}
