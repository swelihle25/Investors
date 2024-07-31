package com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.enviro.assessment.grad001.Dto.CreateWithdrawalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Investor;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Product;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Entities.Withdrawal;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.InvestorRepository;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.ProductRepository;
import com.enviro.assessment.grad001.swelihlekhuzwayo.investors.Repositories.WithdrawalRepository;
import com.opencsv.CSVWriter;

@Service
public class WithdrawalService {

    private WithdrawalRepository withdrawalRepo;
    private InvestorRepository investorRepository;
    private ProductRepository productRepo;

    /**
     * Constructor-based dependency injection for the repositories.
     *
     * @param withdrawalRepo     The repository for handling Withdrawal data operations.
     * @param productRepository  The repository for handling Product data operations.
     * @param investorRepository The repository for handling Investor data operations.
     */
    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepo,
                             ProductRepository productRepository, InvestorRepository investorRepository) {
        this.withdrawalRepo = withdrawalRepo;
        this.investorRepository = investorRepository;
        this.productRepo = productRepository;
    }

    /**
     * Creates a new withdrawal record and associates it with an investor and a product.
     *
     * @param withdrawal The DTO containing data to create a new Withdrawal.
     * @return A list of all withdrawal records.
     */
    public List<Withdrawal> createWithdrawal(CreateWithdrawalDto withdrawal) {
        // Fetching the investor associated with the withdrawal
        Investor invest = this.investorRepository.findById(withdrawal.getInvestor_id()).orElseThrow(
                () -> new IllegalArgumentException("Invalid investor ID: " + withdrawal.getInvestor_id()));

        // Fetching the product associated with the withdrawal
        Product product = this.productRepo.findById(withdrawal.getProduct_id()).orElseThrow(
                () -> new IllegalArgumentException("Invalid product ID: " + withdrawal.getProduct_id()));

        // Creating a new Withdrawal instance and setting its properties
        Withdrawal w = new Withdrawal();
        w.setAmount(withdrawal.getAmount());
        w.setAccountNumber(withdrawal.getAccountNumber());
        w.setInvestor(invest);
        w.setProduct(product);

        // Saving the new withdrawal record
        this.withdrawalRepo.save(w);
        // Returning the list of all withdrawals
        return this.withdrawalRepo.findAll();
    }

    /**
     * Writes product details and associated withdrawals to a CSV file.
     *
     * @param productId The ID of the product to write data for.
     * @param filePath  The file path to write the CSV to.
     */
    public void writeProductsToCsv(long productId, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header to the CSV file
            String[] header = {"ID", "Product Name", "Investor", "Account Number", "Amount", "Created Date"};
            writer.writeNext(header);

            // Fetch the product by ID
            Product product = this.productRepo.findById(productId).orElseThrow(
                    () -> new IllegalArgumentException("Invalid product ID: " + productId));

            // Write each associated withdrawal's details to the CSV
            for (Withdrawal withdrawal : product.getWithdrawals()) {
                String[] data = {
                        withdrawal.getId().toString(),
                        withdrawal.getProduct().getProductName(),
                        withdrawal.getInvestor().getInvestorName(),
                        withdrawal.getAccountNumber(),
                        String.valueOf(withdrawal.getAmount()),
                        withdrawal.getCreatedDate().toString()
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            // Handle potential I/O exceptions
            e.printStackTrace();
        }
    }
}
