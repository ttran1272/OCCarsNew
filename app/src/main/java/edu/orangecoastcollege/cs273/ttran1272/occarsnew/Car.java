package edu.orangecoastcollege.cs273.ttran1272.occarsnew;

/**
 * Created by AnhTran on 9/20/2017.
 */

import java.text.DecimalFormat;

public class Car {

    private final double APR_3_YEARS = 0.0462;
    private final double APR_4_YEARS = 0.0419;
    private final double APR_5_YEARS = 0.0416;
    private final double TAX_RATE = 0.85;
    public final DecimalFormat MONEY = new DecimalFormat("#,##0.00");

    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;


    public Car() {
        setDownPayment(10000);
        setLoanTerm(5);
        setPrice(50000);

    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        if (downPayment >= 0){
            mDownPayment = downPayment;
        }
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        if (loanTerm >= 0) {
            mLoanTerm = loanTerm;
        }
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            mPrice = price;
        }
    }

    public String getFormatedDownPayment(){
        return MONEY.format(mDownPayment);

    }

    public String getFormatedPrice(){
        return MONEY.format(mPrice);
    }

    private double calculateBorrowedAmount(){
        return mPrice - mDownPayment;
    }

    public String getFormatedBorrowAmount(){
        return MONEY.format(calculateBorrowedAmount());
    }

    private double calculateInterestAmount(){
        double mRate;
        switch (mLoanTerm){
            case 3:
                mRate = APR_3_YEARS ;
                break;

            case 4:
                mRate = APR_4_YEARS ;
                break;

            case 5:
                mRate = APR_5_YEARS ;
                break;

            default:
                mRate = 0;
                break;
        }

        return (mPrice - mDownPayment) * mLoanTerm * mRate;
    }

    public String getFormatedInterestAmount(){
        return MONEY.format(calculateInterestAmount());
    }

    private double calculateMonthlyPayment(){
        double borrowAmt = calculateBorrowedAmount();
        double interestAmt = calculateInterestAmount();
        double taxAmt = calculateTaxAmount();

        return ( borrowAmt + interestAmt + taxAmt )/ (12 * mLoanTerm);
    }

    public String getFormatedMonthlyPayment(){
        return MONEY.format(calculateMonthlyPayment());
    }

    private double calculateTaxAmount(){
        return mPrice * TAX_RATE;
    }

    public String getFormatedTaxAmount(){
        return MONEY.format(calculateTaxAmount());
    }

    private double calculateTotalCost(){
        double interestAmt = calculateInterestAmount();
        double taxAmt = calculateTaxAmount();

        return  (mPrice + interestAmt + taxAmt);
    }

    public String getFormatedTotalCost(){
        return MONEY.format(calculateTotalCost());
    }
}


