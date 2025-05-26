package com.manojlovski.carmarket.service;

import com.manojlovski.carmarket.dto.request.AccountRequest;
import com.manojlovski.carmarket.dto.response.AccountResponse;
import com.manojlovski.carmarket.model.Account;

import java.util.List;

public interface AccountService {

    List<AccountResponse> listAccounts();

    AccountResponse findById(String id);

    AccountResponse createAccount(AccountRequest accountRequest);

    AccountResponse updateAccount(String id, AccountRequest accountRequest);

    void deleteAccount(String id);
}
