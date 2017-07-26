package com.hackabots.flyknits;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

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

        Intent intent = getIntent();
        ImageView imgView = (ImageView) findViewById(R.id.thumbnail);
        VideoView vidView = (VideoView) findViewById(R.id.videoView);
        TextView titleView = (TextView) findViewById(R.id.title);
        TextView descView = (TextView) findViewById(R.id.desc);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) titleView.getLayoutParams();

        imgView.setVisibility(View.GONE);
        vidView.setVisibility(View.GONE);
        titleView.setText(intent.getIntExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, 0));
        descView.setText(intent.getIntExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, 0));

        // either show image or show video or show nothing
        if (intent.hasExtra(MainActivity.EXTRA_NOTIFICATION_IMG)) {
            imgView.setVisibility(View.VISIBLE);
            layoutParams.addRule(RelativeLayout.BELOW, R.id.thumbnail);
            titleView.setLayoutParams(layoutParams);
            imgView.setImageDrawable(getDrawable(intent.getIntExtra(MainActivity.EXTRA_NOTIFICATION_IMG, 0)));
        } else if (intent.hasExtra(MainActivity.EXTRA_VIDEO_URI)) {
            vidView.setVisibility(View.VISIBLE);
            layoutParams.addRule(RelativeLayout.BELOW, R.id.videoView);
            titleView.setLayoutParams(layoutParams);
            vidView.setVideoURI(Uri.parse(intent.getStringExtra(MainActivity.EXTRA_VIDEO_URI)));
            MediaController vidControl = new MediaController(this);
            vidControl.setAnchorView(vidView);
            vidView.setMediaController(vidControl);
            vidView.start();
        } else {
            CardView cardView = (CardView) findViewById(R.id.card_view);
            cardView.setVisibility(View.INVISIBLE);
        }
    }

    public void launchOpenAccount(View view) {
        Intent intent = new Intent(this, OpenAccountActivity.class);
        TextView text = (TextView) findViewById(R.id.open_account_rrsp);
        String header = text.getText().toString();
        intent.putExtra(EXTRA_HEADER, header);
        startActivity(intent);
    }
}
