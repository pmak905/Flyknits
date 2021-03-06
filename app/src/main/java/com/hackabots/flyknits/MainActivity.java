package com.hackabots.flyknits;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.andremion.counterfab.CounterFab;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_HEADER = "com.hackabots.flyknits.HEADER";
    public static final String EXTRA_BALANCE = "com.hackabots.flyknits.BALANCE";
    public static final String EXTRA_VIDEO_URI = "com.hackabots.flyknits.VIDEO_URI";
    public static final String EXTRA_NOTIFICATION_IMG = "com.hackabots.flyknits.NOTIFICATION_IMG";
    public static final String EXTRA_NOTIFICATION_TITLE = "com.hackabots.flyknits.NOTIFICATION_TITLE";
    public static final String EXTRA_NOTIFICATION_TEXT = "com.hackabots.flyknits.NOTIFICATION_TEXT";

    private int menuSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CounterFab fab = (CounterFab) findViewById(R.id.fabNotification);
        fab.setCount(1); // Set the count value to show on badge
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotificationsActivity.class);
                putNotificationExtras(intent);
                startActivity(intent);
//                Snackbar.make(view, "You have a new job! Open a RRSP account today.", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        menuSelection = item.getItemId();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabNotification);
        fab.setVisibility(View.VISIBLE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /** Open chequing transactions page */
    public void openChqTxns(View view) {
        Intent intent = new Intent(this, DisplayChqTxnsActivity.class);
        TextView account_type = (TextView) findViewById(R.id.chequing_title);
        TextView account_number = (TextView) findViewById(R.id.chequing_account_number);
        TextView account_balance = (TextView) findViewById(R.id.chequing_balance);

        String header = account_type.getText().toString() + " - " + account_number.getText().toString();
        String balance = account_balance.getText().toString();
        intent.putExtra(EXTRA_HEADER, header);
        intent.putExtra(EXTRA_BALANCE, balance);
        startActivity(intent);
    }

    /**
     * This helper sets either the image or the video to load depending on what scenario is selected
     * @param intent The intent to add extras to
     */
    private void putNotificationExtras(Intent intent) {
        switch (menuSelection) {
            case R.id.nav_life_knot: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_knot);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_knot);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_IMG, R.drawable.marriage);
                break;
            }
            case R.id.nav_life_bun: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_life_bun);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_life_bun);
                intent.putExtra(MainActivity.EXTRA_VIDEO_URI, "android.resource://"+getPackageName()+"/"+R.raw.notification_vid_life_bun);
                break;
            }
            case R.id.nav_life_pension: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_pension);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_pension);
                intent.putExtra(MainActivity.EXTRA_VIDEO_URI, "android.resource://"+getPackageName()+"/"+R.raw.notification_vid_pension);
                break;
            }
            case R.id.nav_life_gig: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_new_gig);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_new_gig);
                intent.putExtra(MainActivity.EXTRA_VIDEO_URI, "android.resource://"+getPackageName()+"/"+R.raw.notification_vid_new_gig);
                break;
            }
            case R.id.nav_fumes: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_fumes);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notifications_desc_fumes);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_IMG, R.drawable.fumes);
                break;
            }
            case R.id.nav_break_bank: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_break_bank);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_break_bank);
                intent.putExtra(MainActivity.EXTRA_VIDEO_URI, "android.resource://"+getPackageName()+"/"+R.raw.notification_vid_break_bank);
                break;
            }
            case R.id.nav_new_president: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_new_prez);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_new_prez);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_IMG, R.drawable.notification_img_new_prez);
                break;
            }
            case R.id.nav_brexit: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_brexit);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_brexit);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_IMG, R.drawable.notification_img_brexit);
                break;
            }
            case R.id.nav_jackpot: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_jackpot);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_jackpot);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_IMG, R.drawable.notification_img_jackpot);
                break;
            }
            case R.id.nav_inheritance: {
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TITLE, R.string.notification_title_inheritance);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_TEXT, R.string.notification_desc_inheritance);
                intent.putExtra(MainActivity.EXTRA_NOTIFICATION_IMG, R.drawable.rainy);
                break;
            }
            default:
                break;
        }

    }
}
