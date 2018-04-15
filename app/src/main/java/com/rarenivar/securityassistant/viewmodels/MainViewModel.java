package com.rarenivar.securityassistant.viewmodels;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.data.repository.DecisionRulesRepository;
import com.rarenivar.securityassistant.data.entity.Permission;
import com.rarenivar.securityassistant.models.AppScan;
import com.rarenivar.securityassistant.models.SecurityScan;
import com.rarenivar.securityassistant.receivers.AdminPolicyManager;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public AdminPolicyManager adminPoliciesManager;
    private DecisionRulesRepository repository;
    public SecurityScan securityScan;

    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Permission>> allPermissions;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new DecisionRulesRepository(application);
        allPermissions = repository.getAllPermissions();
        init();
    }

    public void init() {
        adminPoliciesManager = new AdminPolicyManager(getApplication().getApplicationContext());
    }

    public LiveData<List<Permission>> getAllPermissions() {
        return allPermissions;
    }

    public void insert(Permission permission) { repository.insert(permission); }

    public boolean isAppDeviceAdmin() {
        if (adminPoliciesManager.getDevicePolicyManager() != null
                && adminPoliciesManager.isAdminActive()) {
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

    public void performSecurityScan() {
        AppScan scan = new AppScan(getApplication());
        scan.printApps();
    }
}
