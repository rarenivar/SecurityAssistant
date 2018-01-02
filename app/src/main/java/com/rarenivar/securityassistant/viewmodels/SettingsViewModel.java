package com.rarenivar.securityassistant.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.preference.Preference;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.receivers.AdminPolicyManager;
import com.rarenivar.securityassistant.util.Util;


public class SettingsViewModel extends AndroidViewModel {

    private AdminPolicyManager mAdminMngr;

    public SettingsViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    public void init() {
        mAdminMngr = new AdminPolicyManager(this.getApplication().getApplicationContext());
    }

    public Boolean getCameraStatus() {
        return mAdminMngr.getCameraStatus();
    }

    public void setCameraStatus(boolean status) {
        mAdminMngr.setCameraDisabled(status);
    }

    public Preference.OnPreferenceChangeListener
    DisableCameraChangeListener(final String disableMsg, final String enableMsg) {
        final SettingsViewModel vm = this;
        return new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String msg = ((boolean)newValue) ? disableMsg : enableMsg;
                vm.setCameraStatus((boolean)newValue);
                Util.showToast(getApplication().getApplicationContext(), msg);
                return true;
            }
        };
    }
}
