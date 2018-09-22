package com.rarenivar.securityassistant.views;

import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.models.AppScan;
import com.rarenivar.securityassistant.models.ScanObj;
import com.rarenivar.securityassistant.viewmodels.MainViewModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public MainViewModel viewModel;
    private FloatingActionButton appScanButton;
    public TextView scan_results_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        scan_results_textview = findViewById(R.id.scan_results_textview);
        scan_results_textview.setText(getString(R.string.perform_scan_msg));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (viewModel.isAppDeviceAdmin()) {
            if (!viewModel.isPasswordSufficient()) {
                // password needs to be sufficient to use the app
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
        appScanButton = findViewById(R.id.security_scan_button);
        appScanButton.setOnClickListener((View v) -> {
                scan_results_textview.setText(getString(R.string.scanning_msg));
                new AgentAsyncTask(MainActivity.this, viewModel).execute();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == getResources().getInteger(R.integer.DEVICE_ADMIN_REQUEST_CODE)) {
            // requesting admin rights
            if (resultCode == RESULT_OK) {
                if (!viewModel.isPasswordSufficient()) {
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
            if (resultCode != RESULT_OK) {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(this, AboutActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static class AgentAsyncTask extends AsyncTask<Void, Void, String> {

        // Weak reference to activity to prevent memory leak
        private WeakReference<MainActivity> weakActivity;
        private MainViewModel viewModel;

        AgentAsyncTask(MainActivity activity, MainViewModel viewModel) {
            this.weakActivity = new WeakReference<>(activity);
            this.viewModel = viewModel;
        }

        @Override
        protected String doInBackground(Void... params) {
            StringBuilder appsmatching = new StringBuilder("");
            AppScan scan = new AppScan(weakActivity.get());
            ArrayList<ScanObj> objs = scan.getScanObjs();
            for (ScanObj obj : objs)
            {
                List<DecisionRule> rules = viewModel.getMatchingDecisionRules(Arrays.asList(obj.getPermissions()));
                if (!rules.isEmpty())
                {
                    appsmatching.append(obj.getAppName() + " ");
                }
            }
            if (appsmatching == null || appsmatching.toString().equals("")) {
                appsmatching.append(weakActivity.get().getString(R.string.no_scan_results_msg));
            }
            return appsmatching.toString();
        }

        @Override
        protected void onPostExecute(String apps) {
            weakActivity.get().scan_results_textview.setText(apps);
        }
    }

}
