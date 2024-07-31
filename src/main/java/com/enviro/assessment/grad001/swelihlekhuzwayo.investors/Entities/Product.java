package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Withdrawal> withdrawals;
}
