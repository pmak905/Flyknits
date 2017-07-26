package com.hackabots.flyknits;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.hackabots.flyknits.R.id.chequing_balance;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_HEADER = "com.hackabots.flyknits.HEADER";
    public static final String EXTRA_BALANCE = "com.hackabots.flyknits.BALANCE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabNotification);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotificationsActivity.class);
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
        int id = item.getItemId();

        if(item.isCheckable()){
            if(item.isChecked()){
                item.setChecked(false);
                item.setIcon(R.drawable.ic_checkbox_empty);
            }
            else {
                item.setChecked(true);
                item.setIcon(R.drawable.ic_checkbox_checked);
            }
        }

        if (id == R.id.nav_life_knot) {

        } else if (id == R.id.nav_life_bun) {

        } else if (id == R.id.nav_life_pension) {

        } else if (id == R.id.nav_life_gig) {

        } else if (id == R.id.nav_fumes) {

        } else if (id == R.id.nav_brake_bank) {

        } else if (id == R.id.nav_tax_loss_harvest) {

        } else if (id == R.id.nav_new_president) {

        } else if (id == R.id.nav_brexit) {

        } else if (id == R.id.nav_jackpot) {

        } else if (id == R.id.nav_inheritance) {

        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
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
}
