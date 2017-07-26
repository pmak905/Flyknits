package com.hackabots.flyknits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.hackabots.flyknits.MainActivity.EXTRA_HEADER;

/**
 * Created by eric.wong on 2017-07-23.
 */

public class NotificationsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        // Set page header
//        Intent intent = getIntent();
//        String header = intent.getStringExtra(MainActivity.EXTRA_HEADER);
    }

    public void launchOpenAccount(View view) {
        Intent intent = new Intent(this, OpenAccountActivity.class);
//        TextView text = (TextView) findViewById(R.id.chequing_title);
//        String header = text.getText().toString();
//        intent.putExtra(EXTRA_HEADER, header);
        startActivity(intent);
    }
}
