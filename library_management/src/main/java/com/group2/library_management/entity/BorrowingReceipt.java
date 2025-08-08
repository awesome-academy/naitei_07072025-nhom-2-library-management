package com.group2.library_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "borrowing_receipts")
@Getter
@Setter
public class BorrowingReceipt extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "borrowed_date", nullable = false)
    private LocalDateTime borrowedDate;

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;

    @Column(nullable = false)
    private Integer status;

    @Column(name = "rejected_reason", columnDefinition = "TEXT")
    private String rejectedReason;

    @OneToMany(mappedBy = "borrowingReceipt")
    private List<BorrowingDetail> borrowingDetails;

    @OneToMany(mappedBy = "borrowingReceipt")
    private List<ReceiptFine> receiptFines;
}
