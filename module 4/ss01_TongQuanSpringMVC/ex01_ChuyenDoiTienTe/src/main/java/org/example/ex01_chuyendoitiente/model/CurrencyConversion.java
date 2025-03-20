package org.example.ex01_chuyendoitiente.model;

public class CurrencyConversion {
    private double rate;
    private double amount;
    private double result;

    public CurrencyConversion() {}

    public CurrencyConversion(double rate, double amount) {
        this.rate = rate;
        this.amount = amount;
        this.result = rate * amount;
    }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
}
