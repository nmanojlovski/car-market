package com.manojlovski.carmarket.dto.request;

import com.manojlovski.carmarket.model.Car;
import com.manojlovski.carmarket.model.enums.SellerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerRequest {

    @NotBlank
    private String name;

    private String address;

    private String phone;

    @NotNull
    private SellerType sellerType;

    private List<String> carIds;

}