package com.manojlovski.carmarket.model;

import com.manojlovski.carmarket.model.base.BaseEntity;
import com.manojlovski.carmarket.model.enums.SellerType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String address;

    private String phone;

    @Column(name = "seller_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SellerType sellerType;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Car> cars;
}
