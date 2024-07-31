package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Investor;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Services.InvestorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    private final InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService _investorService) {
        this.investorService = _investorService;
    }

    /**
     * Endpoint to get a list of all investors.
     *
     * @return ResponseEntity containing a list of all investors and an HTTP status.
     */
    @GetMapping("")
    public ResponseEntity<List<Investor>> getAllInvestors() {
        try {
            List<Investor> investors = this.investorService.getAllInvestors();
            return new ResponseEntity<>(investors, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return a 500 Internal Server Error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint to get a specific investor by ID.
     *
     * @param id The ID of the investor to retrieve.
     * @return ResponseEntity containing the investor and an HTTP status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {
        try {
            Investor investor = investorService.getInvestorById(id);
            return new ResponseEntity<>(investor, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return a 500 Internal Server Error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint to create a new investor.
     *
     * @param investor The Investor object to be created.
     * @return The created Investor object.
     * @throws Exception If there is an issue during creation.
     */
    @PostMapping("")
    public Investor createInvestor(@RequestBody Investor investor) throws Exception {
        return investorService.saveInvestor(investor);
    }

    /**
     * Endpoint to update an existing investor.
     *
     * @param id The ID of the investor to update.
     * @param investor The updated Investor object.
     * @return The updated Investor object.
     */
    @PutMapping("/{id}")
    public Investor updateInvestor(@PathVariable Long id, @RequestBody Investor investor) {
        investor.setId(id);
        try {
            return investorService.saveInvestor(investor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Endpoint to delete an investor by ID.
     *
     * @param id The ID of the investor to delete.
     * @throws Exception If there is an issue during deletion.
     */
    @DeleteMapping("/{id}")
    public void deleteInvestor(@PathVariable Long id) throws Exception {
        investorService.deleteInvestor(id);
    }
}
