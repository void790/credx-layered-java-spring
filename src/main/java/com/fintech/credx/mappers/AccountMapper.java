package com.fintech.credx.mappers;

import com.fintech.credx.dtos.AccountDto;
import com.fintech.credx.dtos.CardDto;
import com.fintech.credx.entities.Account;
import com.fintech.credx.entities.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(Account account);
    Account toEntity(AccountDto dto);

    List<AccountDto> toDtoList(List<Account> entities);
}
