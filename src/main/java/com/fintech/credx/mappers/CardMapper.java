package com.fintech.credx.mappers;

import com.fintech.credx.dtos.CardDto;
import com.fintech.credx.entities.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardDto toDto(Card saved);
    Card toEntity(CardDto dto);

    List<CardDto> toDtoList(List<Card> entities);
}
