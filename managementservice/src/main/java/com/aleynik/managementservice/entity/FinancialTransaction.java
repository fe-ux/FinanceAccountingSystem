package com.aleynik.managementservice.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "financial_transaction")
public class FinancialTransaction {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "account", updatable = false, nullable = false)
    private UUID account;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", updatable = false, nullable = false)
    private Date date;

    @Column(name = "type", updatable = false, nullable = false)
    private Boolean type;

    @Column(name = "sum", updatable = false, nullable = false)
    private BigDecimal sum;

    @Column(name = "description", updatable = false, length = 100)
    private String description;
}
