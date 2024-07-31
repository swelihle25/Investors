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

    private WithdrawalRepository _withdrawalRepo;
    private InvestorRepository _investorRepository;
    private ProductRepository _productRepo;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepo,
                             ProductRepository productRepository, InvestorRepository investorRepository){
        this._withdrawalRepo = withdrawalRepo;
        this._investorRepository = investorRepository;
        this._productRepo = productRepository;
    }

    public List<Withdrawal> createWithdrawal(CreateWithdrawalDto withdrawal){

        Investor invest = this._investorRepository.findById(withdrawal.investor_id).get();

        Product product = this._productRepo.findById(withdrawal.product_id).get();

        Withdrawal w = new Withdrawal();
        w.setAmount(withdrawal.amount);
        w.setAccountNumber(withdrawal.accountNumber);

        w.setInvestor(invest);
        w.setProduct(product);

        this._withdrawalRepo.save(w);
        List<Withdrawal> list = this._withdrawalRepo.findAll();
        return list;

    }

    public void writeProductsToCsv(long productId,String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header
            String[] header = {"ID", "Product Name", "Investor", "Account Number", "Price", "Created By" };
            writer.writeNext(header);
            Product products = this._productRepo.findById(productId).get();

            // Write data
            for (Withdrawal withdrawal : products.getWithdrawals()) {
                String[] data = {withdrawal.getId().toString(), withdrawal.getProduct().getProductName(),
                        withdrawal.getInvestor().getInvestorName(),
                        withdrawal.getAccountNumber() , withdrawal.getAmount() + "", withdrawal.getCreatedDate().toString()

                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}