package com.rarenivar.securityassistant.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.viewmodels.SettingsViewModel;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_container, new SettingsFragment())
                .commit();
    }


    public static class SettingsFragment extends PreferenceFragment {

        private SettingsViewModel viewModel;
        private CheckBoxPreference disableCameraChckbox;
        private CheckBoxPreference encryptDeviceChckbox;
        private CheckBoxPreference connectSecuredWiFiChckbox;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            viewModel = ViewModelProviders.of((FragmentActivity)getActivity())
                    .get(SettingsViewModel.class);
            disableCameraChckbox = (CheckBoxPreference)findPreference(getResources()
                    .getString(R.string.settings_disable_camera));
            disableCameraChckbox.setOnPreferenceChangeListener
                    (viewModel.DisableCameraChangeListener("disableee", "enallbeeee"));
        }
    }
}
