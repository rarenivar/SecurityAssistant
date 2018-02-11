//package com.rarenivar.securityassistant.data;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//import com.rarenivar.securityassistant.R;
//import com.rarenivar.securityassistant.receivers.AdminPolicyManager;
//import com.rarenivar.securityassistant.util.Util;
//
//
//public class SettingsDAO {
//
//    private SharedPreferences mPref;
//    private Context mContext;
//    private AdminPolicyManager mAdminMgr;
//
//    public SettingsDAO(Context context) {
//        mContext = context;
//        mPref = PreferenceManager.getDefaultSharedPreferences(mContext);
//        mAdminMgr = new AdminPolicyManager(context.getApplicationContext());
//    }
//
////    public Boolean getPreferenceCameraStatus() {
////        return mAdminMgr.getCameraStatus();
////        //mPref.getBoolean(String.format(mContext.getString(R.string.settings_disable_camera)),false))
////    }
//
//    private Util.EncryptionStatus encryptionStatus() {
//        return mAdminMgr.getEncryptionStatus();
//        //return mPref.getBoolean(String.format(mContext.getString(R.string.settings_encrypt_device)),false);
//    }
//
//    public boolean canEncrypt() {
//        return (encryptionStatus() == Util.EncryptionStatus.Inactive) ? true : false;
//    }
//
////    public Boolean canOnlyConnectToSecuredWiFis() {
////        return mPref.getBoolean(String.format(mContext.getString(R.string.settings_secured_wifis)),
////                false);
////    }
////
////    public Long getScreenTimeout() {
////        return mAdminMgr.getScreenTimeToLock();
////        //return mPref.getInt(String.format(mContext.getString(R.string.settings_screen_timeout)),-1);
////    }
////
////    public int getMaxNumberAttemptsToWipe() {
////        return mAdminMgr.getMaxAttemptsToWipe();
////        //return mPref.getInt(String.format(mContext.getString(R.string.settings_failed_password)),-1);
////    }
//}
