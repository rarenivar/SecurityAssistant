package com.rarenivar.securityassistant.viewmodels;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.receivers.AdminPolicyManager;

public class MainViewModel extends AndroidViewModel {

    public AdminPolicyManager adminPoliciesManager;

    public MainViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    public void init() {
        adminPoliciesManager = new AdminPolicyManager(getApplication().getApplicationContext());
    }

    public boolean isAppDeviceAdmin() {
        if (adminPoliciesManager.getDevicePolicyManager() != null && adminPoliciesManager.isAdminActive()) {
            return true;
        }
        return false;
    }

    public Intent getAdminRequestIntent() {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminPoliciesManager.getComponentName());
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, R.string.admin_request_msg);
        return intent;
    }

    public boolean isPasswordSufficient() {
        return adminPoliciesManager.isPasswordSufficient();
    }
}
