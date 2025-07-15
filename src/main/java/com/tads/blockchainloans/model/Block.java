package com.tads.blockchainloans.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "blocks")
public class Block {
    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private LocalDateTime timestamp;
    @Setter
    @Getter
    private String previousHash;
    @Setter
    @Getter
    private String currentHash;

    // Préstamo
    @Setter
    @Getter
    private String companyName;
    @Setter
    @Getter
    private BigDecimal amount;
    @Setter
    @Getter
    private Double interestRate;
    @Setter
    @Getter
    private LocalDate dueDate;

}
