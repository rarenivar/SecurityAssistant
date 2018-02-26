package com.rarenivar.securityassistant.views;

import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.viewmodels.MainViewModel;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView textview = findViewById(R.id.dude);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (viewModel.isAppDeviceAdmin()) {
            if (viewModel.isPasswordSufficient()) {
                // app has admin rights, load home page
                //loadHomePage();
            } else {
                Intent setPasswordIntent =
                        new Intent(DevicePolicyManager.ACTION_SET_NEW_PASSWORD);
                startActivityForResult(setPasswordIntent,
                        getResources().getInteger(R.integer.SET_PASSWORD_REQUEST_CODE));
            }
        } else {
            // need to request admin rights in order to use the app
            startActivityForResult(viewModel.getAdminRequestIntent(),
                    getResources().getInteger(R.integer.DEVICE_ADMIN_REQUEST_CODE));
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == getResources().getInteger(R.integer.DEVICE_ADMIN_REQUEST_CODE)) {
            // requesting admin rights
            if (resultCode == RESULT_OK) {
                if (viewModel.isPasswordSufficient()) {
                    //loadHomePage();
                } else {
                    Intent setPasswordIntent =
                            new Intent(DevicePolicyManager.ACTION_SET_NEW_PASSWORD);
                    startActivityForResult(setPasswordIntent,
                            getResources().getInteger(R.integer.SET_PASSWORD_REQUEST_CODE));
                }
            } else {
                startActivityForResult(viewModel.getAdminRequestIntent(),
                        getResources().getInteger(R.integer.DEVICE_ADMIN_REQUEST_CODE));
            }
        }
        else if (requestCode == getResources().getInteger(R.integer.SET_PASSWORD_REQUEST_CODE)) {
            if (resultCode == RESULT_OK) {
                //loadHomePage();
            } else {
                startActivityForResult(viewModel.getAdminRequestIntent(),
                        getResources().getInteger(R.integer.DEVICE_ADMIN_REQUEST_CODE));
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_appscan) {
            startActivity(new Intent(this, AppScanActivity.class));
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this, AboutActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadHomePage() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView textview = findViewById(R.id.dude);
    }
}
