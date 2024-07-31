package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.Dto.CreateWithdrawalDto;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Withdrawal;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Services.WithdrawalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;

    /**
     * Constructor-based dependency injection for WithdrawalService.
     * @param withdrawalService The service handling business logic for withdrawals.
     */
    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    /**
     * Endpoint to create a new withdrawal.
     *
     * @param withdrawal The DTO containing the withdrawal details.
     * @return ResponseEntity containing the list of withdrawals and an HTTP status.
     */
    @PostMapping("")
    public ResponseEntity<List<Withdrawal>> createWithdrawal(@RequestBody CreateWithdrawalDto withdrawal) {
        try {
            List<Withdrawal> list = withdrawalService.createWithdrawal(withdrawal);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return a 500 Internal Server Error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint to generate a CSV report of withdrawals for a specific investor.
     *
     * @param id The ID of the investor whose withdrawals are to be exported.
     * @return ResponseEntity with an HTTP status.
     */
    @GetMapping("{id}")
    public ResponseEntity<Void> downloadWithdrawal(@PathVariable Long id) {
        try {
            withdrawalService.writeProductsToCsv(id, "./job.csv");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return a 500 Internal Server Error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
