package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


@RequestMapping("/api/investors")
@RestController
public class InvestorController {

    private InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService _investorService){
        this.investorService = _investorService;
    }


    @GetMapping("")
    public ResponseEntity<List<Investor>> getAllInvestors() {
        try {
            List<Investor> investor = this.investorService.getAllInvestors();
            return new ResponseEntity<>(investor, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to get an investor by id
    @GetMapping("/{id}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {
        try {
            Investor invest = investorService.getInvestorById(id).get();
            return new ResponseEntity<>(invest, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Endpoint to create a new investor


    public Investor createInvestor(@RequestBody Investor investor) {
        return investorService.saveInvestor(investor);
    }

    // Endpoint to update an existing investor
    @PutMapping("path/{id}")
    // public SomeEnityData putMethodName(@PathVariable String id, @RequestBody SomeEnityData entity) {
    // 	//TODO: process PUT request

    // 	return entity;
    // }("/{id}")
    // public Investor updateInvestor(@PathVariable Long id, @RequestBody Investor investor) {
    // 	investor.setId(id);
    // 	return investorService.saveInvestor(investor);
    // }

    // Endpoint to delete an investor
    @DeleteMapping("/{id}")
    public void deleteInvestor(@PathVariable Long id) {
        investorService.deleteInvestor(id);
    }
}

