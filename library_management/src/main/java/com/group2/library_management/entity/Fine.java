package com.group2.library_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "fines")
@Getter
@Setter
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal fee;

    @OneToMany(mappedBy = "fine")
    private List<ReceiptFine> receiptFines;
}
