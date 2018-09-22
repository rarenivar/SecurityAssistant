package com.rarenivar.securityassistant.viewmodels;

import android.app.Application;
import android.app.admin.DevicePolicyManager;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.repository.DecisionRulesRepository;
import com.rarenivar.securityassistant.receivers.AdminPolicyManager;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static final String CAMERA_RECOMMENDATION = "Disable camera\n";
    private static final String ENCRYPTION_RECOMMENDATION = "Encrypt file system\n";
    private static final String UNSECURED_ACCESS_POINT_RECOMMENDATION = "Disable unsecured access points";
    private static final String NO_RECOMMENDATIONS = "All security settings look good!";

    private AdminPolicyManager adminPoliciesManager;
    private DecisionRulesRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new DecisionRulesRepository(application);
        init();
    }

    public List<DecisionRule> getMatchingDecisionRules(List<String> permissionList) {
        return repository.getMatchingDecisionRules(permissionList);
    }

    private void init() {
        adminPoliciesManager = new AdminPolicyManager(getApplication().getApplicationContext());
    }

    public boolean isAppDeviceAdmin() {
        return (adminPoliciesManager.getDevicePolicyManager() != null
                && adminPoliciesManager.isAdminActive()) ? true : false;
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

    public String getSecuritySetttingRecommendations()
    {
        StringBuilder recommendations = new StringBuilder("");
        if (!adminPoliciesManager.getCameraStatus()) {
            recommendations.append(CAMERA_RECOMMENDATION);
        }
        if (!adminPoliciesManager.isStorageEncrypted()) {
            recommendations.append(ENCRYPTION_RECOMMENDATION);
        }
        if (adminPoliciesManager.getUnsecuredWiFiStatus()) {
            recommendations.append(UNSECURED_ACCESS_POINT_RECOMMENDATION);
        }
        if (recommendations.toString().equals("")) {
            recommendations.append(NO_RECOMMENDATIONS);
        }
        return recommendations.toString();
    }
}
