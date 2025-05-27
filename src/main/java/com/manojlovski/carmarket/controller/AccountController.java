package com.manojlovski.carmarket.controller;

import com.manojlovski.carmarket.dto.request.AccountRequest;
import com.manojlovski.carmarket.dto.response.AccountResponse;
import com.manojlovski.carmarket.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<AccountResponse> listAccounts() {
        return accountService.listAccounts();
    }

    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable String id) {
        return accountService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@RequestBody @Valid AccountRequest accountRequest) {
        return accountService.createAccount(accountRequest);
    }

    @PutMapping("/{id}")
    public AccountResponse updateAccount(@PathVariable String id, @RequestBody @Valid AccountRequest accountRequest) {
        return accountService.updateAccount(id, accountRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

}
