package com.rarenivar.securityassistant.viewmodels;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.receivers.AdminPolicyManager;
import com.rarenivar.securityassistant.views.MainActivity;


public class MainViewModel extends AndroidViewModel {

    public AdminPolicyManager adminPoliciesManager;

    public MainViewModel(@NonNull Application application) {
        super(application);
        adminPoliciesManager = new AdminPolicyManager(getApplication().getApplicationContext());
    }

    public void init() {

    }

    public boolean isAppDeviceAdmin() {
        if (adminPoliciesManager.getmDPM() != null && adminPoliciesManager.isAdminActive()) {
            return true;
        }
        return false;
    }

    public Intent getAdminRequestIntent() {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminPoliciesManager.getmDeviceAdmin());
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "some explanation here");
        return intent;
    }
}
