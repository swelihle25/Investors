package com.enviro.assessment.grad001.Dto;

public class CreateWithdrawalDto {

    private double amount;
    private String accountNumber;
    private Long product_id;
    private Long investor_id;

    private String withdrawalReason;
    private String withdrawalDate;
    private String transactionId;
    private String currency;

    // Constructors
    public CreateWithdrawalDto() {}

    public CreateWithdrawalDto(double amount, String accountNumber, Long product_id, Long investor_id, String withdrawalReason, String withdrawalDate, String transactionId, String currency) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.product_id = product_id;
        this.investor_id = investor_id;
        this.withdrawalReason = withdrawalReason;
        this.withdrawalDate = withdrawalDate;
        this.transactionId = transactionId;
        this.currency = currency;
    }

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getInvestor_id() {
        return investor_id;
    }

    public void setInvestor_id(Long investor_id) {
        this.investor_id = investor_id;
    }

    public String getWithdrawalReason() {
        return withdrawalReason;
    }

    public void setWithdrawalReason(String withdrawalReason) {
        this.withdrawalReason = withdrawalReason;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
