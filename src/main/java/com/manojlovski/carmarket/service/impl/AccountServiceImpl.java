package com.manojlovski.carmarket.service.impl;

import com.manojlovski.carmarket.config.exception.NotFoundException;
import com.manojlovski.carmarket.dto.request.AccountRequest;
import com.manojlovski.carmarket.dto.response.AccountResponse;
import com.manojlovski.carmarket.model.Account;
import com.manojlovski.carmarket.model.Customer;
import com.manojlovski.carmarket.repository.AccountRepository;
import com.manojlovski.carmarket.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<AccountResponse> listAccounts() {
        return accountRepository.findAll().stream().map(this::mapToAccountResponse).collect(Collectors.toList());
    }

    @Override
    public AccountResponse findById(String id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Account with the id: " + id + " not found")
        );

        return mapToAccountResponse(account);
    }

    @Override
    @Transactional
    public AccountResponse createAccount(AccountRequest accountRequest) {
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setEmail(accountRequest.getEmail());
        accountRepository.save(account);

        return mapToAccountResponse(account);
    }

    @Override
    @Transactional
    public AccountResponse updateAccount(String id, AccountRequest accountRequest) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Account with the id: " + id + " not found")
        );

        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setEmail(accountRequest.getEmail());
        accountRepository.save(account);

        return mapToAccountResponse(account);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    private AccountResponse mapToAccountResponse(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setUsername(account.getUsername());
        accountResponse.setEmail(account.getEmail());

        if (account.getCustomer() != null) {
            accountResponse.setCustomerId(account.getCustomer().getId());
        }

        accountResponse.setCreatedAt(account.getCreatedAt());
        accountResponse.setUpdatedAt(account.getUpdatedAt());

        return accountResponse;
    }

}
