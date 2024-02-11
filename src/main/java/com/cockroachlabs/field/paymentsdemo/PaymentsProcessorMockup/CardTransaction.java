package com.cockroachlabs.field.paymentsdemo.PaymentsProcessorMockup;

import java.util.Objects;
import java.util.UUID;
import java.time.Instant;

public class CardTransaction {

    private UUID transactionId;
    private Instant transactionDate;
    private Double amount;
    private String currency;
    private String cardNumber;
    private String cardExpirationMonth;
    private String cardExpirationYear;
    private String cardHolderName;
    private String merchantCode;
    private String merchantReferenceCode;
    private String status;
    private String authorizationCode;

    public CardTransaction() {

    }

    CardTransaction(UUID transactionId, Instant transactionDate, Double amount, String currency, String cardNumber, String cardExpirationMonth, String cardExpirationYear, String cardHolderName, String merchantCode, String merchantReferenceCode) {

        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.currency = currency;
        this.cardNumber = cardNumber;
        this.cardExpirationMonth = cardExpirationMonth;
        this.cardExpirationYear = cardExpirationYear;
        this.cardHolderName = cardHolderName;
        this.merchantCode = merchantCode;
        this.merchantReferenceCode = merchantReferenceCode;
    }
    public UUID getTransactionId() {
        return this.transactionId;
    }
    public Instant getTransactionDate() {
        return this.transactionDate;
    }
    public Double getAmount() {
        return this.amount;
    }
    public String getCurrency() {
        return this.currency;
    }
    public String getCardNumber() {
        return this.cardNumber;
    }
    public String getCardExpirationMonth() {
        return this.cardExpirationMonth;
    }
    public String getCardExpirationYear() {
        return this.cardExpirationYear;
    }
    public String getCardHolderName() {
        return this.cardHolderName;
    }
    public String getMerchantCode() {
        return this.merchantCode;
    }
    public String getMerchantReferenceCode() {
        return this.merchantReferenceCode;
    }
    public String getStatus() {
        return this.status;
    }
    public String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }
    public void setTransactionDate(Instant transactionDate) {
        this.transactionDate = transactionDate;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setCardExpirationMonth(String cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }
    public void setCardExpirationYear(String cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
    public void setMerchantReferenceCode(String merchantReferenceCode) {
        this.merchantReferenceCode = merchantReferenceCode;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof CardTransaction))
            return false;
        CardTransaction cardTransaction = (CardTransaction) o;
        return Objects.equals(this.transactionId, cardTransaction.transactionId)
                && Objects.equals(this.transactionDate, cardTransaction.transactionDate)
                && Objects.equals(this.amount, cardTransaction.amount)
                && Objects.equals(this.currency, cardTransaction.currency)
                && Objects.equals(this.cardNumber, cardTransaction.cardNumber)
                && Objects.equals(this.cardExpirationMonth, cardTransaction.cardExpirationMonth)
                && Objects.equals(this.cardExpirationYear, cardTransaction.cardExpirationYear)
                && Objects.equals(this.cardHolderName, cardTransaction.cardHolderName)
                && Objects.equals(this.merchantCode, cardTransaction.merchantCode)
                && Objects.equals(this.merchantReferenceCode, cardTransaction.merchantReferenceCode)
                && Objects.equals(this.status, cardTransaction.status)
                && Objects.equals(this.authorizationCode, cardTransaction.authorizationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.transactionId,
                this.transactionDate,
                this.amount,
                this.currency,
                this.cardNumber,
                this.cardExpirationMonth,
                this.cardExpirationYear,
                this.cardHolderName,
                this.merchantCode,
                this.merchantReferenceCode,
                this.status,
                this.authorizationCode);
    }

    @Override
    public String toString() {
        return "CardTransaction {"
                + "Transaction ID = " + this.transactionId
                + ", Transaction Date = " + this.transactionDate
                + ", Amount = " + this.amount
                + ", Card Number = '" + this.cardNumber + '\''
                + ", Card Exp Month = '" + this.cardExpirationMonth + '\''
                + ", Card Exp Year = '" + this.cardExpirationYear + '\''
                + ", Card Holder Name = '" + this.cardHolderName + '\''
                + ", Merchant Code = '" + this.merchantCode + '\''
                + ", Merchant Reference Code = '" + this.merchantReferenceCode + '\''
                + ", Status = '" + this.status + '\''
                + ", Authorization = '" + this.authorizationCode + '\''
                + '}';
    }

}
