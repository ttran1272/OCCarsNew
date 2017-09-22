package edu.orangecoastcollege.cs273.ttran1272.occarsnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static edu.orangecoastcollege.cs273.ttran1272.occarsnew.R.id.downPaymentEditText;

public class PurchaseActivity extends AppCompatActivity {

    public static Car myCar;
    private EditText priceEditText;
    private EditText downPaymentEditText;

    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private int term;
    private Button loanReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCar = new Car();
        setContentView(R.layout.activity_purchase);

        calculate();

        reportSummary();
    }

    public void calculate(){

        priceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.carPriceEditText);

        String price = priceEditText.getText().toString();
        String downPayment = downPaymentEditText.getText().toString();

        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = mRadioGroup.getCheckedRadioButtonId();
        mRadioButton = (RadioButton) findViewById(selectedId);

        RadioButton threeYearTerm = (RadioButton) findViewById(R.id.radioButton3Y);
        RadioButton fourYearTerm = (RadioButton) findViewById(R.id.radioButton4Y);
        RadioButton fiveYearTerm = (RadioButton) findViewById(R.id.radioButton5Y);

        try {
            if (mRadioButton == threeYearTerm) {
                term = 3;
            } else if (mRadioButton == fourYearTerm) {
                term = 4;
            } else {
                term = 5;
            }
        } catch (Exception e){
            Log.w("PurchaseActivity", "Exception in the radio button selection")
        }


        try {
            double priceAmt = Double.parseDouble(price);
            double downPaymentAmt = Double.parseDouble(downPayment);

            myCar.setPrice(priceAmt);
            myCar.setDownPayment(downPaymentAmt);
            myCar.setLoanTerm(term);


        }
        catch (NumberFormatException e) {
            Log.w("PurchaseActivity", "Errow in function calculate() " + e);
        }
    }


    public void reportSummary(View v){

        String monthlyPymt = myCar.getFormatedMonthlyPayment();
        String priceAmt = myCar.getFormatedPrice();
        String downPymt = myCar.getFormatedDownPayment();
        String taxPymt = myCar.getFormatedTaxAmount();
        String costAmt = myCar.getFormatedTotalCost();
        String borrowAmt = myCar.getFormatedBorrowAmount();
        String interestAmt = myCar.getFormatedInterestAmount();
        String loanTerm = String.valueOf(myCar.getLoanTerm());


        Intent myIntent = new Intent(this, LoanSummaryActivity.class);

        String loanReport = getString(R.string.report_line1) + monthlyPymt
                + getString(R.string.report_line2) + priceAmt
                + getString(R.string.report_line3) + downPymt
                + getString(R.string.report_line5) + taxPymt
                + getString(R.string.report_line6) + costAmt
                + getString(R.string.report_line7) + borrowAmt
                + getString(R.string.report_line8) + interestAmt
                + getString(R.string.report_line4) + loanTerm ;


        String note = getString(R.string.report_line9) + getString(R.string.report_line10)
                + getString(R.string.report_line11);

        startActivity(myIntent);
    }

}
