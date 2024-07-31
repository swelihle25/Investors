package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Investor;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.InvestorRepository;

@Service
public class InvestorService {

    private final InvestorRepository investorRepo;

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepo = investorRepository;

        Investor investor1 = new Investor();
        investor1.setInvestorName("John");
        investor1.setInvestorSurname("Doe");
        investor1.setInvestorEmail("john.doe@example.com");
        investor1.setDateOfBirth(LocalDate.of(1990, 5, 15));
        investor1.setAddress("123 Main Street");
        investor1.setAge(31);

        investorRepo.save(investor1);

        Investor investor2 = new Investor();
        investor2.setInvestorName("Jane");
        investor2.setInvestorSurname("Smith");
        investor2.setInvestorEmail("jane.smith@example.com");
        investor2.setDateOfBirth(LocalDate.of(1985, 8, 20));
        investor2.setAddress("456 Elm Street");
        investor2.setAge(36);
        investorRepo.save(investor2);
    }

    public List<Investor> getAllInvestors() throws Exception {
        try {
            List<Investor> investors = new ArrayList<>();
            investorRepo.findAll().forEach(investors::add);
            return investors;
        } catch (Exception e) {
            throw new Exception("Failed to get investors", e);
        }
    }

    public Investor getInvestorById(Long id) throws Exception {
        try {
            Optional<Investor> investor = investorRepo.findById(id);
            return investor.orElse(null);
        } catch (Exception e) {
            throw new Exception("Failed to get investor by id: " + id, e);
        }
    }

    public Investor saveInvestor(Investor investor) throws Exception {
        try {
            return investorRepo.save(investor);
        } catch (Exception e) {
            throw new Exception("Failed to save investor", e);
        }
    }

    public void deleteInvestor(Long id) throws Exception {
        try {
            investorRepo.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Failed to delete investor with id: " + id, e);
        }
    }
}

