package com.manojlovski.carmarket.config.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityPatterns {
    public static final String[] ACCOUNT = { "/api/accounts" };
    public static final String[] ALL = { "/**" };

}
