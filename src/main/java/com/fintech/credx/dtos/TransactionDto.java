package com.fintech.credx.dtos;

import com.fintech.credx.common.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransactionDto {
    private UUID id;
    private UUID accountId;
    private UUID cardId;
    private BigDecimal amount;
    private TransactionType type;
    private String description;
    private String reference;
    private LocalDateTime transactionDate;
    private boolean linked;
}
