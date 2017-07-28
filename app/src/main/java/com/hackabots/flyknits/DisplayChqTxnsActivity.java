package com.hackabots.flyknits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.hackabots.flyknits.R.id.transaction_1_balance;

public class DisplayChqTxnsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_chq_txns);

        // Set page header
        Intent intent = getIntent();
        String header = intent.getStringExtra(MainActivity.EXTRA_HEADER);
        String header_balance = intent.getStringExtra(MainActivity.EXTRA_BALANCE);
        TextView balanceTextView = (TextView) findViewById(R.id.page_account_balance);
        TextView headerTextView = (TextView) findViewById(R.id.page_account_information);
        TextView transaction1balanceTextView = (TextView) findViewById(R.id.transaction_1_balance);
        headerTextView.setText(header);
        balanceTextView.setText(header_balance);
        transaction1balanceTextView.setText("Balance: " + header_balance);
    }
}
