package com.rarenivar.securityassistant.viewmodels;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.repository.DecisionRulesRepository;
import com.rarenivar.securityassistant.data.entity.Permission;
import com.rarenivar.securityassistant.models.AppScan;
import com.rarenivar.securityassistant.models.SecurityScan;
import com.rarenivar.securityassistant.receivers.AdminPolicyManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public AdminPolicyManager adminPoliciesManager;
    private DecisionRulesRepository repository;
    public SecurityScan securityScan;
    public LiveData<List<DecisionRule>> decisions;
//    private MutableLiveData<List<String>> malwareApps = new MutableLiveData<List<String>>() {
//        @Override
//        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<List<String>> observer) {
//            super.observe(owner, observer);
//        }
//    };
//
//    private MutableLiveData<List<DecisionRule>> decisionRules = new MutableLiveData<List<DecisionRule>>() {
//        @Override
//        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<List<DecisionRule>> observer) {
//            super.observe(owner, observer);
//        }
//    };

    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.


    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new DecisionRulesRepository(application);
        init();
    }

    public List<DecisionRule> getMatchingDecisionRules(List<String> permissionList) {
        return repository.getMatchingDecisionRules(permissionList);
    }

    public void updateMalwareApp() {
        //List<String> permissions = Arrays.asList(AppScan.getRequestedPermissions(packageInfo));
        List<String> permissions = new ArrayList<>();
        permissions.add("android.permission.INTERNET");
        permissions.add("android.permission.READ_SMS");
        permissions.add("android.permission.WRITE_EXTERNAL_STORAGE");
        //decisionRules.setValue(repository.getMatchingDecisionRules(permissions));//repository.getMachingDecisionRules(permissions);
    }

    public void init() {
        adminPoliciesManager = new AdminPolicyManager(getApplication().getApplicationContext());
    }

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
    }
}
