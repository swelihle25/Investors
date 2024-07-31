package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String investorName;
    private String investorSurname;
    private String investorEmail;
    private LocalDate dateOfBirth;
    private String address;
    private int age;

    @OneToMany(mappedBy = "investor", cascade = CascadeType.ALL)
    private List<Withdrawal> withdrawals;
}
