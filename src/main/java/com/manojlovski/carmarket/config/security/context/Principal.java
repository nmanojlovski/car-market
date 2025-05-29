package com.manojlovski.carmarket.config.security.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Principal {

    private String accountId;

    private String email;

    private String username;

    private String customerId;
}
