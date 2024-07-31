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

    /**
     * Constructor-based dependency injection for InvestorRepository.
     * Initializes the service and optionally pre-populates some test data.
     *
     * @param investorRepository The repository handling Investor data operations.
     */
    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepo = investorRepository;

        // Sample data for demonstration purposes
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

    /**
     * Retrieves all investors from the repository.
     *
     * @return A list of all investors.
     * @throws Exception If there is an error during retrieval.
     */
    public List<Investor> getAllInvestors() throws Exception {
        try {
            List<Investor> investors = new ArrayList<>();
            investorRepo.findAll().forEach(investors::add);
            return investors;
        } catch (Exception e) {
            throw new Exception("Failed to get investors", e);
        }
    }

    /**
     * Retrieves an investor by their ID.
     *
     * @param id The ID of the investor to retrieve.
     * @return The Investor object if found, otherwise null.
     * @throws Exception If there is an error during retrieval.
     */
    public Investor getInvestorById(Long id) throws Exception {
        try {
            Optional<Investor> investor = investorRepo.findById(id);
            return investor.orElse(null);
        } catch (Exception e) {
            throw new Exception("Failed to get investor by id: " + id, e);
        }
    }

    /**
     * Saves an investor to the repository.
     *
     * @param investor The Investor object to be saved.
     * @return The saved Investor object.
     * @throws Exception If there is an error during the save operation.
     */
    public Investor saveInvestor(Investor investor) throws Exception {
        try {
            return investorRepo.save(investor);
        } catch (Exception e) {
            throw new Exception("Failed to save investor", e);
        }
    }

    /**
     * Deletes an investor by their ID.
     *
     * @param id The ID of the investor to delete.
     * @throws Exception If there is an error during the delete operation.
     */
    public void deleteInvestor(Long id) throws Exception {
        try {
            investorRepo.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Failed to delete investor with id: " + id, e);
        }
    }
}
