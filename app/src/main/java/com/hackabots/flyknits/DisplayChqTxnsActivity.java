package com.hackabots.flyknits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayChqTxnsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_chq_txns);

        // Set page header
        Intent intent = getIntent();
        String header = intent.getStringExtra(MainActivity.EXTRA_HEADER);
        TextView textView = (TextView) findViewById(R.id.chqHeader);
        textView.setText(header);
    }
}
