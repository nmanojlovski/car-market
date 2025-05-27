package com.manojlovski.carmarket.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AccountResponse {

    private String id;

    private String username;

    private String email;

    private String customerId;

    private Instant createdAt;

    private Instant updatedAt;
}
