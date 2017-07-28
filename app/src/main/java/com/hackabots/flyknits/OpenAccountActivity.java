package com.hackabots.flyknits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        if ("Life Bun".equals(header))
            planTypeSpinner.setSelection(0); // RESP
        else if ("Goodbye Tension, Hello Pension".equals(header))
            planTypeSpinner.setSelection(1); // RRIF
        else if ("Tie the Knot".equals(header))
            planTypeSpinner.setSelection(2); // RRSP
        else if ("You got a job!".equals(header))
            planTypeSpinner.setSelection(3); // TFSA
    }

    public void submitNewAccountOnClick(View view) {

        Spinner s = (Spinner) findViewById(R.id.plan_type);
        String msg = s.getSelectedItem().toString() + " account created successfully!";

        TextView header = (TextView) findViewById(R.id.main_page_text);
        header.setText(msg);

        TextView ev = (TextView) findViewById(R.id.editText);
        ev.setVisibility(View.INVISIBLE);
        s.setVisibility(View.INVISIBLE);
        ev = (TextView) findViewById(R.id.textView3);
        ev.setVisibility(View.INVISIBLE);
        ev = (TextView) findViewById(R.id.textView4);
        ev.setVisibility(View.INVISIBLE);
        Button b = (Button) findViewById(R.id.button);
        b.setVisibility(View.INVISIBLE);
    }
}
