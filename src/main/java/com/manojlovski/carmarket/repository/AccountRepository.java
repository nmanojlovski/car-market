package com.manojlovski.carmarket.repository;

import com.manojlovski.carmarket.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
