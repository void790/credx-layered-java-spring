package com.fintech.credx.controllers;

import com.fintech.credx.common.enums.AccountStatus;
import com.fintech.credx.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class AccountController {

    private final AccountService service;




}
