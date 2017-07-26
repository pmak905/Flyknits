package com.hackabots.flyknits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class OpenAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_account);

        Intent intent = getIntent();
        String header = intent.getStringExtra(MainActivity.EXTRA_HEADER);
        Spinner planTypeSpinner = (Spinner) findViewById(R.id.plan_type);

        if (header.equals("You got a job!")) {
            // RRSP
            planTypeSpinner.setSelection(2);
        }
    }
}
