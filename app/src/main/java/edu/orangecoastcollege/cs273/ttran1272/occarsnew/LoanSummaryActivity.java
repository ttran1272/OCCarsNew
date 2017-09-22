package edu.orangecoastcollege.cs273.ttran1272.occarsnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("loanReport");
        String note = intentFromPurchase.getStringExtra("note"):

        // Fill TextView with data from the report
        TextView loanSummaryTextView = (TextView) findViewById(R.id.loanSummaryTextView);
        TextView noteTextView = (TextView) findViewById(R.id.noteTextView);

        loanSummaryTextView.setText(report);
        noteTextView.setText(note);


    }
}
