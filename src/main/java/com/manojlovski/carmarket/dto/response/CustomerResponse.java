package com.manojlovski.carmarket.dto.response;

import com.manojlovski.carmarket.model.Car;
import com.manojlovski.carmarket.model.enums.SellerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class CustomerResponse {

    private String id;

    private String name;

    private String address;

    private String phone;

    private SellerType sellerType;

    private List<String> carIds;

    private Instant createdAt;

    private Instant updatedAt;
}
