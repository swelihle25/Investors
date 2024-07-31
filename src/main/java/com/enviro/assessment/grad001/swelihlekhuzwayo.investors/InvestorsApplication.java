package com.enviro.assessment.grad001;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Investor;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.InvestorRepository;

@SpringBootApplication
public class InvestorsApplication {

    @Autowired
    // static InvestorRepository investorRepository;
    public static void main(String[] args) {

        SpringApplication.run(InvestorsApplication.class, args);
    }

}
