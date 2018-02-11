package com.rarenivar.securityassistant.views;

import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.receivers.AdminPolicyManager;
import com.rarenivar.securityassistant.util.Util;

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

        private AdminPolicyManager adminPolicyManager;
        private CheckBoxPreference disableCameraCheckbox;
        private CheckBoxPreference encryptDeviceCheckbox;
        private CheckBoxPreference connectSecuredWiFiChckbox;

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
        }

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            adminPolicyManager = new AdminPolicyManager(getActivity());
            addPreferencesFromResource(R.xml.preferences);

            disableCameraCheckbox = (CheckBoxPreference)findPreference(getResources()
                                    .getString(R.string.settings_disable_camera));
            disableCameraCheckbox.setChecked(adminPolicyManager.getCameraStatus());
            disableCameraCheckbox.setOnPreferenceChangeListener(
                    new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object newStatus) {

                            String msg = ((boolean)newStatus) ?
                                    getString(R.string.disable_camera_update_msg) :
                                    getString(R.string.enable_camera_update_msg);
                            adminPolicyManager.setCameraDisabled((boolean)newStatus);
                            Util.showToast(getActivity().getApplicationContext(), msg);
                            return true;
                        }
                    }
            );

            encryptDeviceCheckbox = (CheckBoxPreference)findPreference(getResources()
                                   .getString(R.string.settings_encrypt_device));
            encryptDeviceCheckbox.setChecked(adminPolicyManager.isStorageEncrypted());
            if (adminPolicyManager.isStorageEncrypted() || !adminPolicyManager.isEncryptionSupported()) {
                encryptDeviceCheckbox.setEnabled(false);
            }
            encryptDeviceCheckbox.setOnPreferenceChangeListener(
                    new Preference.OnPreferenceChangeListener() {
                        @Override
                        public boolean onPreferenceChange(Preference preference, Object newStatus) {
                            if ((boolean)newStatus) {
                                Intent intent =
                                        new Intent(DevicePolicyManager.ACTION_START_ENCRYPTION);
                                startActivityForResult(intent, getResources()
                                        .getInteger(R.integer.START_ENCRYPTION_REQUEST_CODE));
                            }
                            // We don't want to update the checkbox yet since we don't know if the
                            // encryption process was successful
                            return false;
                        }
                    }
            );

            connectSecuredWiFiChckbox = (CheckBoxPreference)findPreference(getResources()
                    .getString(R.string.settings_secured_wifis));

        }
    }
}
