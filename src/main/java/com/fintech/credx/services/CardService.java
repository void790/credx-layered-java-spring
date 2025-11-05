package com.fintech.credx.services;

import com.fintech.credx.dtos.CardCriteriaDto;
import com.fintech.credx.dtos.CardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CardService {
    CardDto create(CardDto dto);

    Page<CardDto> getAll(Pageable pageable);

    List<CardDto> getAll();

    CardDto getById(UUID id);

    CardDto update(CardDto dto);

    void delete(UUID id);

    Page<CardDto> search(CardCriteriaDto criteria, Pageable pageable);
}