package com.group2.library_management.entity;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id",referencedColumnName = "id")
    private Edition edition;
    
    @Column(name = "context", nullable = true)
    private String context;
}
