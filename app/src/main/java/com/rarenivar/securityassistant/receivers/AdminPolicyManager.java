package com.rarenivar.securityassistant.receivers;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
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

    private DevicePolicyManager mDPM;
    private ComponentName mDeviceAdmin;
    private Context context;

    public AdminPolicyManager(Context context) {
        this.context = context;
        mDPM = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        mDeviceAdmin = new ComponentName(context, SecurityAssistantDAR.class);
    }

    public void setCameraDisabled(boolean value) {
        mDPM.setCameraDisabled(mDeviceAdmin, value);
    }

    public void setEncryptionPolicy(boolean value) {
        mDPM.setStorageEncryption(mDeviceAdmin, value);
    }

    public void setScreenTimeToLock(long time) {
        mDPM.setMaximumTimeToLock(mDeviceAdmin, time);
    }

    public void setMaxAttemptsToWipe(int attempts) {
        mDPM.setMaximumFailedPasswordsForWipe(mDeviceAdmin, attempts);
    }

    public boolean isStorageEncrypted() {
        int encryptionStatusInt = mDPM.getStorageEncryptionStatus();
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
        int encryptionStatusInt = mDPM.getStorageEncryptionStatus();
        if (encryptionStatusInt == ENCRYPTION_STATUS_UNSUPPORTED) {
            return false;
        }
        return true;
    }

    public boolean encryptDevice() {
        int encryptStatusInt = mDPM.getStorageEncryptionStatus();
        AlertDialog alert = new AlertDialog.Builder(context).create();
        //We're only going to try to encrypt file is encryption is supported
        if (encryptStatusInt == ENCRYPTION_STATUS_INACTIVE) {
            mDPM.setStorageEncryption(mDeviceAdmin, true);
            return true;
        }
        else if (encryptStatusInt == ENCRYPTION_STATUS_UNSUPPORTED) {
            alert.setTitle("the title");
            alert.setIcon(R.drawable.ic_launcher_background);
            alert.setMessage("asdff");
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
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

            alert.setTitle("the title");
            alert.setIcon(R.drawable.ic_launcher_background);
            alert.setMessage("the title");
            alert.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();
        }
        return false;
    }

    public boolean getInstallFromUnknownSourcesValue() {
        // Let's always assume it's true unless proven otherwise
        boolean isUnknownSources = true;
        try {
            isUnknownSources = android.provider.Settings.Secure
                    .getInt(context.getContentResolver(),
                            Settings.Secure.INSTALL_NON_MARKET_APPS) == 1;
        } catch (Settings.SettingNotFoundException e) {
            // TODO: handle exception
        }
        return isUnknownSources;
    }

    public boolean getUnsecuredWiFiStatus() {
        return true;//AppSettings.getSecuredWifiOnlyFlag(context);
    }

    public boolean getCameraStatus() {
        return mDPM.getCameraDisabled(mDeviceAdmin);
    }

    public long getScreenTimeToLock() {
        return mDPM.getMaximumTimeToLock(mDeviceAdmin);
    }

    public int getMaxAttemptsToWipe() {
        return mDPM.getMaximumFailedPasswordsForWipe(mDeviceAdmin);
    }

    public Util.EncryptionStatus getEncryptionStatus() {
        int encryptStatusInt = mDPM.getStorageEncryptionStatus();
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

    public DevicePolicyManager getmDPM() {
        return mDPM;
    }

    public ComponentName getmDeviceAdmin() {
        return mDeviceAdmin;
    }

    public boolean isAdminActive() {
        return mDPM.isAdminActive(mDeviceAdmin);
    }

    public void removeAdminRights() {
        this.getmDPM().removeActiveAdmin(this.getmDeviceAdmin());
    }

    public boolean enforceUsageOfPassword() {
        // TODO: uncommend, this is comment it out just for testing
        /*this.getmDPM().setMaximumTimeToLock(this.getmDeviceAdmin(),);

        this.getmDPM().setPasswordQuality(this.getmDeviceAdmin(),
                DevicePolicyManager.PASSWORD_QUALITY_COMPLEX);

        if (this.getmDPM().isActivePasswordSufficient()) {
            return true;
        }*/
        // If password is not sufficient
        return false;
    }
}

