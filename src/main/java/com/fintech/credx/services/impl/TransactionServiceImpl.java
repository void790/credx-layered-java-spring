package com.fintech.credx.services.impl;

import com.fintech.credx.dtos.TransactionCriteriaDto;
import com.fintech.credx.dtos.TransactionDto;
import com.fintech.credx.entities.QTransaction;
import com.fintech.credx.entities.Transaction;
import com.fintech.credx.mappers.TransactionMapper;
import com.fintech.credx.repositories.TransactionRepository;
import com.fintech.credx.services.TransactionService;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.fintech.credx.common.constants.ErrorMessages.TRANSACTION_NOT_FOUND;
import static com.fintech.credx.common.utils.QueryDslUtils.*;

@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Override
    @Transactional
    public TransactionDto create(TransactionDto dto) {
        Transaction entity = mapper.toEntity(dto);
        Transaction saved = repository.save(entity);

        return mapper.toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public TransactionDto getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException(TRANSACTION_NOT_FOUND + id));
    }

    @Override
    @Transactional
    public TransactionDto update(TransactionDto dto) {
        return repository.findById(dto.getId())
                .map(existing -> {
                    Transaction updated = mapper.toEntity(dto);
                    return mapper.toDto(repository.save(updated));
                })
                .orElseThrow(() -> new EntityNotFoundException(TRANSACTION_NOT_FOUND + dto.getId()));
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        repository.findById(id)
                .ifPresentOrElse(repository::delete, () -> {
                    throw new EntityNotFoundException(TRANSACTION_NOT_FOUND + id);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TransactionDto> search(TransactionCriteriaDto criteria, Pageable pageable) {

        QTransaction q = QTransaction.transaction;
        BooleanBuilder builder = new BooleanBuilder();

        addIfPresent(builder, criteria.getAccountName(), id -> builder.and(q.account.name.eq(id)));
        addIfPresent(builder, criteria.getType(), t -> builder.and(q.type.eq(t)));
        addDateRange(builder, criteria.getFromDate(), criteria.getToDate(), () -> q.transactionDate);
        addIfNotBlank(builder, criteria.getDescription(), desc -> builder.and(q.description.containsIgnoreCase(desc)));

        return repository.findAll(builder, pageable).map(mapper::toDto);
    }
}
