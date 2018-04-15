package com.rarenivar.securityassistant.data;

import com.rarenivar.securityassistant.data.entity.DecisionRule;
import com.rarenivar.securityassistant.data.entity.Permission;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Permission> generatePermissions() {
        List<Permission> permissionList = new ArrayList<>();
        permissionList.add(new Permission(5,"android.permission.INTERNET"));
        permissionList.add(new Permission(6,"android.permission.READ_EXTERNAL_STORAGE"));
        permissionList.add(new Permission(7,"android.permission.WRITE_EXTERNAL_STORAGE"));
        permissionList.add(new Permission(8,"android.permission.SEND_SMS"));
        permissionList.add(new Permission(9,"android.permission.WRITE_SMS"));
        permissionList.add(new Permission(10,"android.permission.WAKE_LOCK"));
        permissionList.add(new Permission(11,"android.permission.CALL_PHONE"));
        permissionList.add(new Permission(12,"android.permission.READ_SMS"));
        permissionList.add(new Permission(13,"android.permission.READ_PHONE_STATE"));
        permissionList.add(new Permission(14,"android.permission.ACCESS_FINE_LOCATION"));
        permissionList.add(new Permission(15,"android.permission.ACCESS_NETWORK_STATE"));
        permissionList.add(new Permission(16,"android.permission.READ_CONTACTS"));
        permissionList.add(new Permission(17,"android.permission.BROADCAST_STICKY"));
        permissionList.add(new Permission(18,"android.permission.DISABLE_KEYGUARD"));
        permissionList.add(new Permission(19,"android.permission.READ_CALL_LOG"));
        permissionList.add(new Permission(20,"android.permission.RECEIVE_WAP_PUSH"));
        permissionList.add(new Permission(21,"android.permission.CHANGE_WIFI_STATE"));
        permissionList.add(new Permission(22,"android.permission.SYSTEM_ALERT_WINDOW"));
        permissionList.add(new Permission(23,"android.permission.WRITE_HISTORY_BOOKMARKS"));
        permissionList.add(new Permission(24,"android.permission.READ_HISTORY_BOOKMARKS"));
        permissionList.add(new Permission(25,"android.permission.ACCESS_WIFI_STATE"));
        permissionList.add(new Permission(26,"android.permission.RECEIVE_SMS"));
        permissionList.add(new Permission(27,"android.permission.RESTART_PACKAGES"));
        permissionList.add(new Permission(28,"android.permission.RECORD_AUDIO"));
        permissionList.add(new Permission(29,"android.permission.VIBRATE"));
        permissionList.add(new Permission(30,"android.permission.BLUETOOTH_ADMIN"));
        permissionList.add(new Permission(31,"android.permission.GET_ACCOUNTS"));
        permissionList.add(new Permission(32,"android.permission.READ_SYNC_SETTINGS"));
        permissionList.add(new Permission(33,"android.permission.ACCESS_LOCATION_EXTRA_COMMANDS"));
        permissionList.add(new Permission(34,"android.permission.ACCESS_MOCK_LOCATION"));
        permissionList.add(new Permission(35,"android.permission.KILL_BACKGROUND_PROCESSES"));
        permissionList.add(new Permission(36,"android.permission.CAMERA"));
        permissionList.add(new Permission(37,"android.permission.WRITE_OWNER_DATA"));
        permissionList.add(new Permission(38,"android.permission.ACCESS_COARSE_LOCATION"));
        permissionList.add(new Permission(39,"android.permission.PROCESS_OUTGOING_CALLS"));
        permissionList.add(new Permission(40,"android.permission.GET_TASKS"));
        permissionList.add(new Permission(41,"android.permission.CHANGE_NETWORK_STATE"));
        permissionList.add(new Permission(42,"android.permission.USE_CREDENTIALS"));
        permissionList.add(new Permission(43,"android.permission.CHANGE_CONFIGURATION"));
        permissionList.add(new Permission(44,"android.permission.SET_WALLPAPER"));
        permissionList.add(new Permission(45,"android.permission.WRITE_SETTINGS"));
        permissionList.add(new Permission(46,"android.permission.READ_OWNER_DATA"));
        permissionList.add(new Permission(47,"android.permission.EXPAND_STATUS_BAR"));
        permissionList.add(new Permission(48,"android.permission.CLEAR_APP_CACHE"));
        permissionList.add(new Permission(49,"android.permission.BIND_WALLPAPER"));
        permissionList.add(new Permission(50,"android.permission.FLASHLIGHT"));
        permissionList.add(new Permission(51,"android.permission.BLUETOOTH"));
        permissionList.add(new Permission(52,"android.permission.RECEIVE_BOOT_COMPLETED"));
        return permissionList;
    }

    public static List<DecisionRule> generateDecisionRules() {
        List<DecisionRule> decisionRuleList = new ArrayList<>();
        decisionRuleList.add(new DecisionRule(0,281,1,99.7f));
        decisionRuleList.add(new DecisionRule(1,189,1,99.6f));
        decisionRuleList.add(new DecisionRule(2,286,1,99.5f));
        decisionRuleList.add(new DecisionRule(3,261,1,99.3f));
        decisionRuleList.add(new DecisionRule(4,109,1,99.2f));
        decisionRuleList.add(new DecisionRule(5,266,1,99.2f));
        decisionRuleList.add(new DecisionRule(6,206,1,99.1f));
        decisionRuleList.add(new DecisionRule(7,212,1,99.1f));
        decisionRuleList.add(new DecisionRule(8,293,1,98.9f));
        decisionRuleList.add(new DecisionRule(9,215,1,98.9f));
        decisionRuleList.add(new DecisionRule(10,44,1,98.9f));
        decisionRuleList.add(new DecisionRule(11,280,1,98.8f));
        decisionRuleList.add(new DecisionRule(12,277,1,98.5f));
        decisionRuleList.add(new DecisionRule(13,157,1,98.2f));
        decisionRuleList.add(new DecisionRule(14,301,1,98.2f));
        decisionRuleList.add(new DecisionRule(15,56,1,98.2f));
        decisionRuleList.add(new DecisionRule(16,244,1,98f));
        decisionRuleList.add(new DecisionRule(17,268,1,97.9f));
        decisionRuleList.add(new DecisionRule(18,243,1,97.9f));
        decisionRuleList.add(new DecisionRule(19,147,1,97.7f));
        decisionRuleList.add(new DecisionRule(20,303,1,97.6f));
        decisionRuleList.add(new DecisionRule(21,72,1,97.5f));
        return decisionRuleList;
    }

}
