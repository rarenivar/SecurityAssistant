package com.rarenivar.securityassistant.data;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Permissions> generatePermissions() {
        List<Permissions> permissionsList = new ArrayList<>();
        permissionsList.add(new Permissions(5,"android.permission.INTERNET"));
        permissionsList.add(new Permissions(6,"android.permission.READ_EXTERNAL_STORAGE"));
        permissionsList.add(new Permissions(7,"android.permission.WRITE_EXTERNAL_STORAGE"));
        permissionsList.add(new Permissions(8,"android.permission.SEND_SMS"));
        permissionsList.add(new Permissions(9,"android.permission.WRITE_SMS"));
        permissionsList.add(new Permissions(10,"android.permission.WAKE_LOCK"));
        permissionsList.add(new Permissions(11,"android.permission.CALL_PHONE"));
        permissionsList.add(new Permissions(12,"android.permission.READ_SMS"));
        permissionsList.add(new Permissions(13,"android.permission.READ_PHONE_STATE"));
        permissionsList.add(new Permissions(14,"android.permission.ACCESS_FINE_LOCATION"));
        permissionsList.add(new Permissions(15,"android.permission.ACCESS_NETWORK_STATE"));
        permissionsList.add(new Permissions(16,"android.permission.READ_CONTACTS"));
        permissionsList.add(new Permissions(17,"android.permission.BROADCAST_STICKY"));
        permissionsList.add(new Permissions(18,"android.permission.DISABLE_KEYGUARD"));
        permissionsList.add(new Permissions(19,"android.permission.READ_CALL_LOG"));
        permissionsList.add(new Permissions(20,"android.permission.RECEIVE_WAP_PUSH"));
        permissionsList.add(new Permissions(21,"android.permission.CHANGE_WIFI_STATE"));
        permissionsList.add(new Permissions(22,"android.permission.SYSTEM_ALERT_WINDOW"));
        permissionsList.add(new Permissions(23,"android.permission.WRITE_HISTORY_BOOKMARKS"));
        permissionsList.add(new Permissions(24,"android.permission.READ_HISTORY_BOOKMARKS"));
        permissionsList.add(new Permissions(25,"android.permission.ACCESS_WIFI_STATE"));
        permissionsList.add(new Permissions(26,"android.permission.RECEIVE_SMS"));
        permissionsList.add(new Permissions(27,"android.permission.RESTART_PACKAGES"));
        permissionsList.add(new Permissions(28,"android.permission.RECORD_AUDIO"));
        permissionsList.add(new Permissions(29,"android.permission.VIBRATE"));
        permissionsList.add(new Permissions(30,"android.permission.BLUETOOTH_ADMIN"));
        permissionsList.add(new Permissions(31,"android.permission.GET_ACCOUNTS"));
        permissionsList.add(new Permissions(32,"android.permission.READ_SYNC_SETTINGS"));
        permissionsList.add(new Permissions(33,"android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"));
        permissionsList.add(new Permissions(34,"android.permission.ACCESS_MOCK_LOCATION"));
        permissionsList.add(new Permissions(35,"android.permission.KILL_BACKGROUND_PROCESSES"));
        permissionsList.add(new Permissions(36,"android.permission.CAMERA"));
        permissionsList.add(new Permissions(37,"android.permission.WRITE_OWNER_DATA"));
        permissionsList.add(new Permissions(38,"android.permission.ACCESS_COARSE_LOCATION"));
        permissionsList.add(new Permissions(39,"android.permission.PROCESS_OUTGOING_CALLS"));
        permissionsList.add(new Permissions(40,"android.permission.GET_TASKS"));
        permissionsList.add(new Permissions(41,"android.permission.CHANGE_NETWORK_STATE"));
        permissionsList.add(new Permissions(42,"android.permission.USE_CREDENTIALS"));
        permissionsList.add(new Permissions(43,"android.permission.CHANGE_CONFIGURATION"));
        permissionsList.add(new Permissions(44,"android.permission.SET_WALLPAPER"));
        permissionsList.add(new Permissions(45,"android.permission.WRITE_SETTINGS"));
        permissionsList.add(new Permissions(46,"android.permission.READ_OWNER_DATA"));
        permissionsList.add(new Permissions(47,"android.permission.EXPAND_STATUS_BAR"));
        permissionsList.add(new Permissions(48,"android.permission.CLEAR_APP_CACHE"));
        permissionsList.add(new Permissions(49,"android.permission.BIND_WALLPAPER"));
        permissionsList.add(new Permissions(50,"android.permission.FLASHLIGHT"));
        permissionsList.add(new Permissions(51,"android.permission.BLUETOOTH"));
        permissionsList.add(new Permissions(52,"android.permission.RECEIVE_BOOT_COMPLETED"));
        return permissionsList;
    }

    public static List<DecisionRules> generateDecisionRules() {
        List<DecisionRules> decisionRulesList = new ArrayList<>();
        decisionRulesList.add(new DecisionRules (0,281,1,99.7f));
        decisionRulesList.add(new DecisionRules (1,189,1,99.6f));
        decisionRulesList.add(new DecisionRules (2,286,1,99.5f));
        decisionRulesList.add(new DecisionRules (3,261,1,99.3f));
        decisionRulesList.add(new DecisionRules (4,109,1,99.2f));
        decisionRulesList.add(new DecisionRules (5,266,1,99.2f));
        decisionRulesList.add(new DecisionRules (6,206,1,99.1f));
        decisionRulesList.add(new DecisionRules (7,212,1,99.1f));
        decisionRulesList.add(new DecisionRules (8,293,1,98.9f));
        decisionRulesList.add(new DecisionRules (9,215,1,98.9f));
        decisionRulesList.add(new DecisionRules (10,44,1,98.9f));
        decisionRulesList.add(new DecisionRules (11,280,1,98.8f));
        decisionRulesList.add(new DecisionRules (12,277,1,98.5f));
        decisionRulesList.add(new DecisionRules (13,157,1,98.2f));
        decisionRulesList.add(new DecisionRules (14,301,1,98.2f));
        decisionRulesList.add(new DecisionRules (15,56,1,98.2f));
        decisionRulesList.add(new DecisionRules (16,244,1,98f));
        decisionRulesList.add(new DecisionRules (17,268,1,97.9f));
        decisionRulesList.add(new DecisionRules (18,243,1,97.9f));
        decisionRulesList.add(new DecisionRules (19,147,1,97.7f));
        decisionRulesList.add(new DecisionRules (20,303,1,97.6f));
        decisionRulesList.add(new DecisionRules (21,72,1,97.5f));
        return decisionRulesList;
    }

}
