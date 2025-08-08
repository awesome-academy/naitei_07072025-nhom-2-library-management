package com.group2.library_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing_details")
@Getter
@Setter
public class BorrowingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "borrowing_receipt_id", nullable = false)
    private BorrowingReceipt borrowingReceipt;

    @ManyToOne
    @JoinColumn(name = "book_instance_id", nullable = false)
    private BookInstance bookInstance;

    @Column(name = "refund_date")
    private LocalDateTime refundDate;
}
