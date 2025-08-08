package com.group2.library_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book_instances")
@Getter
@Setter
public class BookInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = false)
    private Edition edition;

    @Column(nullable = false, unique = true, length = 100)
    private String barcode;

    @Column(name = "call_number", nullable = false, length = 100)
    private String callNumber;

    @Column(name = "acquired_date", nullable = false)
    private LocalDate acquiredDate;

    @Column(name = "acquired_price", precision = 10, scale = 2)
    private BigDecimal acquiredPrice;

    @Column(nullable = false)
    private Integer status;

    @Column(columnDefinition = "TEXT")
    private String note;

    @OneToMany(mappedBy = "bookInstance")
    private List<BorrowingDetail> borrowingDetails;

    @OneToMany(mappedBy = "bookInstance")
    private List<ReceiptFine> receiptFines;
}
