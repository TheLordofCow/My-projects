//Assignment 1
//Jaxson Meisenhelter
//Calculator.java
package com.example.tipcalc;

public class Calculator {
    private double bill;
    private double tip;

    public Calculator() {
    }

    public Calculator(double bill, double tip) {
        this.tip = tip;
        this.bill = bill;
    }

    public double total(){
        return bill*tip;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }
}
