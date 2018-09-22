package com.rarenivar.securityassistant.receivers;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.rarenivar.securityassistant.R;
import com.rarenivar.securityassistant.util.Util;

import static android.app.admin.DevicePolicyManager.ENCRYPTION_STATUS_ACTIVATING;
import static android.app.admin.DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE;
import static android.app.admin.DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY;
import static android.app.admin.DevicePolicyManager.ENCRYPTION_STATUS_ACTIVE_PER_USER;
import static android.app.admin.DevicePolicyManager.ENCRYPTION_STATUS_INACTIVE;
import static android.app.admin.DevicePolicyManager.ENCRYPTION_STATUS_UNSUPPORTED;


public class AdminPolicyManager {

    private static long DEFAULT_SCREEN_TIME_TO_LOCK = 180000L;
    private static int DEFAULT_MAX_FAILED_PASSWORDS_FOR_WIPE = 100;
    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;
    private Context context;

    public AdminPolicyManager(Context context) {
        this.context = context;
        devicePolicyManager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(context, SecurityAssistantDAR.class);
    }

    public void setCameraDisabled(boolean value) {
        devicePolicyManager.setCameraDisabled(componentName, value);
    }

    public void setEncryptionPolicy(boolean value) {
        devicePolicyManager.setStorageEncryption(componentName, value);
    }

    public void setScreenTimeToLock(long time) {
        devicePolicyManager.setMaximumTimeToLock(componentName, time);
    }

    public void setMaxAttemptsToWipe(int attempts) {
        try {
            devicePolicyManager.setMaximumFailedPasswordsForWipe(componentName, attempts);
        }
        catch (SecurityException ex) {

        }
    }

    public boolean isStorageEncrypted() {
        int encryptionStatusInt = devicePolicyManager.getStorageEncryptionStatus();
        boolean status;
        if (encryptionStatusInt == ENCRYPTION_STATUS_ACTIVATING ||
            encryptionStatusInt == ENCRYPTION_STATUS_ACTIVE ||
            encryptionStatusInt == ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY ||
            encryptionStatusInt == ENCRYPTION_STATUS_ACTIVE_PER_USER) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public boolean isEncryptionSupported() {
        int encryptionStatusInt = devicePolicyManager.getStorageEncryptionStatus();
        if (encryptionStatusInt == ENCRYPTION_STATUS_UNSUPPORTED) {
            return false;
        }
        return true;
    }

    public boolean encryptDevice() {
        int encryptStatusInt = devicePolicyManager.getStorageEncryptionStatus();
        AlertDialog alert = new AlertDialog.Builder(context).create();
        //We're only going to try to encrypt file is encryption is supported
        if (encryptStatusInt == ENCRYPTION_STATUS_INACTIVE) {
            devicePolicyManager.setStorageEncryption(componentName, true);
            return true;
        }
        else if (encryptStatusInt == ENCRYPTION_STATUS_UNSUPPORTED) {
            alert.setTitle(context.getString(R.string.encryption_msg_title));
            alert.setIcon(R.drawable.ic_launcher_background);
            alert.setMessage(context.getString(R.string.encryption_not_supported_msg));
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, context.getString(R.string.ok_button),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();
        }
        else if (encryptStatusInt == ENCRYPTION_STATUS_ACTIVATING ||
                encryptStatusInt == ENCRYPTION_STATUS_ACTIVE ||
                encryptStatusInt == ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY ||
                encryptStatusInt == ENCRYPTION_STATUS_ACTIVE_PER_USER) {

            alert.setTitle(context.getString(R.string.encryption_msg_title));
            alert.setIcon(R.drawable.ic_launcher_background);
            alert.setMessage(context.getString(R.string.encryption_active_msg));
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, context.getString(R.string.ok_button),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();
        }
        return false;
    }

    public boolean getUnsecuredWiFiStatus() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(context.getString(R.string.settings_secured_wifis), true);
    }

    public boolean getCameraStatus() {
        return devicePolicyManager.getCameraDisabled(componentName);
    }

    public long getScreenTimeToLock() {
        return devicePolicyManager.getMaximumTimeToLock(componentName);
    }

    public int getMaxAttemptsToWipe() {
        return devicePolicyManager.getMaximumFailedPasswordsForWipe(componentName);
    }

    public Util.EncryptionStatus getEncryptionStatus() {
        int encryptStatusInt = devicePolicyManager.getStorageEncryptionStatus();
        if (encryptStatusInt == ENCRYPTION_STATUS_INACTIVE) {
            return Util.EncryptionStatus.Inactive;
        }
        else if (encryptStatusInt == ENCRYPTION_STATUS_UNSUPPORTED) {
            return Util.EncryptionStatus.Unsupported;
        }
        else if (encryptStatusInt == ENCRYPTION_STATUS_ACTIVE) {
            return Util.EncryptionStatus.Active;
        }
        return null;
    }

    public DevicePolicyManager getDevicePolicyManager() {
        return devicePolicyManager;
    }

    public ComponentName getComponentName() {
        return componentName;
    }

    public boolean isAdminActive() {
        return devicePolicyManager.isAdminActive(componentName);
    }

    public void removeAdminRights() {
        this.getDevicePolicyManager().removeActiveAdmin(this.getComponentName());
    }


    public void setDefaultScreenMaxTimeToLock() {
        this.getDevicePolicyManager()
                .setMaximumTimeToLock(this.getComponentName(), DEFAULT_SCREEN_TIME_TO_LOCK);
    }

    public void setDefaultMaxFailedPasswordsForWipe() {
        setMaxAttemptsToWipe(DEFAULT_MAX_FAILED_PASSWORDS_FOR_WIPE);
    }

    public void setDevicePasswordQuality() {
        this.getDevicePolicyManager().setPasswordQuality(this.getComponentName(),
                DevicePolicyManager.PASSWORD_QUALITY_NUMERIC);
    }

    public boolean isPasswordSufficient() {
        if (this.getDevicePolicyManager().isActivePasswordSufficient()) {
            return true;
        }
        return false;
    }
}

