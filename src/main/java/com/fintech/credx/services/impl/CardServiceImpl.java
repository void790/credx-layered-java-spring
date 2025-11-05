package com.fintech.credx.services.impl;

import com.fintech.credx.dtos.CardCriteriaDto;
import com.fintech.credx.dtos.CardDto;
import com.fintech.credx.services.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public class CardServiceImpl implements CardService {
    @Override
    public CardDto create(CardDto dto) {
        return null;
    }

    @Override
    public Page<CardDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CardDto> getAll() {
        return List.of();
    }

    @Override
    public CardDto getById(UUID id) {
        return null;
    }

    @Override
    public CardDto update(CardDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Page<CardDto> search(CardCriteriaDto criteria, Pageable pageable) {
        return null;
    }
}
