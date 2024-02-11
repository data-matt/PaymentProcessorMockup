package com.cockroachlabs.field.paymentsdemo.PaymentsProcessorMockup;

public class WeightedStatus {

    private String status;
    private Double weight = 0.0;

    WeightedStatus(String status, Double weight) {
        this.status = status;
        this.weight = weight;
    }

    public String getStatus() {
        return this.status;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
